import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DataScienceOld {
  public static Stream<Penguin> getDataByTrackId(Stream<PenguinData> stream) {
    // TODO
    List<Penguin> plist = new ArrayList<>();
    List<PenguinData> pData = new ArrayList<>();
    String lastId = "null";
    List<Geo> pgeo = new ArrayList<>();
    
    stream.forEach(pd->{pData.add(pd);});
    for(int i = 0; i<pData.size();i++){
      PenguinData pd = pData.get(i);
      if(pd.getTrackID().equals(lastId)){
       pgeo.add(pd.getGeom());
       if(i == pData.size()-1){
         plist.add(new Penguin(pgeo,lastId));
       }
     }else {
       if(lastId.equals("null")){
         pgeo.add(pd.getGeom());
       }else{
         plist.add(new Penguin(pgeo,lastId));
         pgeo.clear();
         pgeo.add(pd.getGeom());
       }
     }
      lastId= pd.getTrackID();
    }
    return plist.stream();
  }

  public static void outputPenguinStream() {
    // TODO
  }

  public static void outputLocationRangePerTrackid(Stream<PenguinData> stream) {
    // TODO
    getDataByTrackId(stream).forEach(p->System.out.println(p.toStringUsingStreams()));
  }

  public static void main(String[] args) {
    // TODO Test your implementation yourself
    Stream<PenguinData> data = CSVReading.processInputFile();
//    data.forEach(p ->System.out.println(p.toString()));
    outputLocationRangePerTrackid(data);
  }
}