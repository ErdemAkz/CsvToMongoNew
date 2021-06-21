package imo;

import com.mongodb.*;
import com.mongodb.hadoop.io.BSONWritable;
import com.mongodb.hadoop.mapred.MongoOutputFormat;
import com.mongodb.hadoop.mapred.output.MongoOutputCommitter;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.tuple.Tuple7;
import com.mongodb.client.MongoDatabase;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.JobContext;
import org.apache.hadoop.mapred.OutputCommitter;
import org.apache.hadoop.mapred.TaskAttemptContext;
import org.bson.BSON;
import org.bson.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.flink.api.common.functions.RichMapFunction;
import org.bson.types.ObjectId;
import org.apache.flink.api.java.hadoop.mapred.HadoopOutputFormat;


class MongoOutputCommitterDelegate extends OutputCommitter {
    private MongoOutputCommitter delegate;
    public MongoOutputCommitterDelegate() {
        MongoClientURI uri = new MongoClientURI("mongodb://127.0.0.1/erdemdb.junk2");
        List<DBCollection> colls = new ArrayList<DBCollection>();
        colls.add(new MongoClient(uri).getDB(uri.getDatabase())
                .getCollection(uri.getCollection()));
        delegate = new MongoOutputCommitter(colls);
    }

	/*
	public static Path getTaskAttemptPath(final TaskAttemptContext context) {
		return MongoOutputCommitter.getTaskAttemptPath(context);
	}
	*/

    @Override
    public void setupJob(final JobContext jobContext) {
        delegate.setupJob(jobContext);
    }

    @Override
    public void setupTask(final TaskAttemptContext taskContext)
            throws IOException {
        delegate.setupJob(taskContext);
    }

    @Override
    public boolean needsTaskCommit(final TaskAttemptContext taskContext)
            throws IOException {
        return delegate.needsTaskCommit(taskContext);
    }

    @Override
    public void commitTask(final TaskAttemptContext taskContext)
            throws IOException {
        delegate.commitTask(taskContext);
    }

    @Override
    public void abortTask(final TaskAttemptContext taskContext)
            throws IOException {
        delegate.abortTask(taskContext);
    }
};

public class Main {
    public static void main(String[] args){
        long start = System.currentTimeMillis();
        try {

            
            final ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();


            DataSet<Tuple7<Integer,String, String,String,Integer,Double,String>> data

                    = env.readCsvFile("src/main/resources/data2.csv")
                    .ignoreFirstLine()
                    .parseQuotedStrings('\"')
                    .types(Integer.class, String.class, String.class, String.class, Integer.class, Double.class, String.class);

            /*
            MongoClient mongo = new MongoClient( "localhost" , 27017 );
            MongoDatabase database = mongo.getDatabase("erdemdb");
            database.getCollection("junk").drop();
            */


            JobConf conf = new JobConf();
            conf.setOutputCommitter(MongoOutputCommitterDelegate.class);
            HadoopOutputFormat<ObjectId, BSONWritable> outputFormat =
                    new HadoopOutputFormat<ObjectId, BSONWritable>(
                            new MongoOutputFormat<ObjectId, BSONWritable>(),
                            conf);

            data.map(new MapFunction<Tuple7<Integer,String, String,String,Integer,Double,String>, Tuple2<ObjectId, BSONWritable>>() {
                @Override
                public Tuple2<ObjectId, BSONWritable> map(Tuple7<Integer,String, String,String,Integer,Double,String> tuple) {
                    return new Tuple2<ObjectId, BSONWritable>(
                            new ObjectId(),
                            new BSONWritable(BasicDBObjectBuilder.start()
                                    .add("number", tuple.getField(0))
                                    .add("name", tuple.getField(1))
                                    .add("product", tuple.getField(2))
                                    .add("date", tuple.getField(3))
                                    .add("count", tuple.getField(4))
                                    .add("price", tuple.getField(5))
                                    .add("tag", tuple.getField(6))
                                    .get())
                    );
                }
            })
                    .output(outputFormat);

            env.execute();






        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis()-start);


    }

}
