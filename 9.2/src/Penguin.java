import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Penguin {
    private List<Geo> locations;
    private String trackID;

    public Penguin(List<Geo> locations, String trackID) {
        this.locations = locations;
        this.trackID = trackID;
    }

    @Override
    public String toString() {
        return "Penguin{" +
                "locations=" + locations +
                ", trackID='" + trackID + '\'' +
                '}';
    }

    public List<Geo> getLocations() {
        return locations;
    }

    public String getTrackID() {
        return trackID;
    }

    // public String toStringUsingStreams()  metodu icin: basi "Penguin{locations=[" sonu " ], trackID=" olan metnin arasindaki konum bilgisini stream ile yazmasi isteniyor. asagida return un icine yazdim ama emin de olamadim bu sekilde olur mu diye.
    public String toStringUsingStreams() {
        // TODO

        return toString();
    }
}
