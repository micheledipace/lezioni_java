package SpotifyItems;

public class Podcast extends PlayableItem {
   private String reportPodcast;

   public Podcast(){
       super();
       reportPodcast = "Default Text";
   }
   public Podcast(String reportPodcast, String playableItemId, String title, int timeLength, String artist, int publicationYear, int publicationDay, int publicationMonth, String trackAudioPath) {

       super(playableItemId, title, timeLength, artist, publicationYear, publicationDay, publicationMonth, trackAudioPath);
       this.reportPodcast = reportPodcast;
   }
   //getters

    public String getReportPodcast() {
        return reportPodcast;
    }

    @Override
    public String toString(){
       return super.toString() + "\nReport: " + reportPodcast;
   }
}
