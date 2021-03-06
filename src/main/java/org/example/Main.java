package imo;

import com.mongodb.*;
import com.mongodb.hadoop.io.BSONWritable;
import com.mongodb.hadoop.mapred.MongoOutputFormat;
import com.mongodb.hadoop.mapred.output.MongoOutputCommitter;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.tuple.Tuple19;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.tuple.Tuple7;
import com.mongodb.client.MongoDatabase;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.JobContext;
import org.apache.hadoop.mapred.OutputCommitter;
import org.apache.hadoop.mapred.TaskAttemptContext;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;
import org.apache.flink.api.java.hadoop.mapred.HadoopOutputFormat;



class MongoOutputCommitterDelegate extends OutputCommitter {
    private MongoOutputCommitter delegate;
    public MongoOutputCommitterDelegate() {
        MongoClientURI uri = new MongoClientURI("mongodb://127.0.0.1/erdemdb.demo");
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

            
            DataSet<Tuple19<String,Integer,Double,Double,Double,Double,Integer,Integer,Integer,String,String, Integer,Integer,Integer,Integer,Integer,Double,String,String>> data
            //DataSet<Tuple7<Integer,String, String,String,Integer,Double,String>> data

                    = env.readCsvFile("src/main/resources/sample-less-data.csv")
                    .ignoreFirstLine()
                    .parseQuotedStrings('\"')
                    .types(String.class,Integer.class,Double.class,Double.class,Double.class,Double.class,Integer.class,Integer.class,Integer.class,String.class,String.class, Integer.class,Integer.class,Integer.class,Integer.class,Integer.class,Double.class,String.class,String.class);




            JobConf conf = new JobConf();
            conf.setOutputCommitter(MongoOutputCommitterDelegate.class);
            HadoopOutputFormat<ObjectId, BSONWritable> outputFormat =
                    new HadoopOutputFormat<ObjectId, BSONWritable>(
                            new MongoOutputFormat<ObjectId, BSONWritable>(),
                            conf);

            data.map(new MapFunction<Tuple19<String,Integer,Double,Double,Double,Double,Integer,Integer,Integer,String,String, Integer,Integer,Integer,Integer,Integer,Double,String,String>, Tuple2<ObjectId, BSONWritable>>() {
                @Override
                public Tuple2<ObjectId, BSONWritable> map(Tuple19<String,Integer,Double,Double,Double,Double,Integer,Integer,Integer,String,String, Integer,Integer,Integer,Integer,Integer,Double,String,String> tuple) {
                    return new Tuple2<ObjectId, BSONWritable>(
                            new ObjectId(),
                            new BSONWritable(BasicDBObjectBuilder.start()
                                    .add("a1", tuple.getField(0))
                                    .add("a2", tuple.getField(1))
                                    .add("a3", tuple.getField(2))
                                    .add("a4", tuple.getField(3))
                                    .add("a5", tuple.getField(4))
                                    .add("a6", tuple.getField(5))
                                    .add("a7", tuple.getField(6))
                                    .add("a8", tuple.getField(7))
                                    .add("a9", tuple.getField(8))
                                    .add("a10", tuple.getField(9))
                                    .add("a11", tuple.getField(10))
                                    .add("a12", tuple.getField(11))
                                    .add("a13", tuple.getField(12))
                                    .add("a14", tuple.getField(13))
                                    .add("a15", tuple.getField(14))
                                    .add("a16", tuple.getField(15))
                                    .add("a17", tuple.getField(16))
                                    .add("a18", tuple.getField(17))
                                    .add("a19", tuple.getField(18))
                                    .get())
                    );
                }
            })
                    .output(outputFormat);

            env.execute();

            /*
                        Tuple7<Integer,String, String,String,Integer,Double,String>

                        .types(Integer.class, String.class, String.class, String.class, Integer.class, Double.class, String.class);

                                    .add("number", tuple.getField(0))
                                    .add("name", tuple.getField(1))
                                    .add("product", tuple.getField(2))
                                    .add("date", tuple.getField(3))
                                    .add("count", tuple.getField(4))
                                    .add("price", tuple.getField(5))
                                    .add("tag", tuple.getField(6))



                       Tuple19<String,Integer,Double,Double,Double,Double,Integer,Integer,Integer,String,String, Integer,Integer,Integer,Integer,Integer,Double,String,String>
                       .types(String.class,Integer.class,Double.class,Double.class,Double.class,Double.class,Integer.class,Integer.class,Integer.class,String.class,String.class, Integer.class,Integer.class,Integer.class,Integer.class,Integer.class,Double.class,String.class,String.class);
             */




        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis()-start);


    }

}
