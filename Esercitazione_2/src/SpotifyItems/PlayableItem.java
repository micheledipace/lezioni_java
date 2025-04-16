package SpotifyItems;

import java.util.Date;

public class PlayableItem {
    private String playableItemId;
    private int timeLength; //time in seconds
    private int currentTime; // cursore che tiene traccia del punto in cui è la riproduzione
    private String artist;
    private String title;
    private Date publicationDate;
    //la conversione avviene in realtime da binario a vibrazioni sonore in base alla posizione del cursore.
    private String trackAudioPath;

    public PlayableItem() {
        playableItemId = "0000";
        title = "Default Title";
        timeLength = 100;
        currentTime = 0;
        artist = "Default Artist";
        publicationDate = new Date();
        trackAudioPath = "Default Track Audio Path";
    }

    public PlayableItem(String playableItemId, String title, int timeLength, String artist, int publicationYear, int publicationDay, int publicationMonth, String trackAudioPath) {
        this.playableItemId = playableItemId;
        this.title = title;
        this.timeLength = timeLength;
        this.artist = artist;
        currentTime = 0;
        this.publicationDate = new Date(publicationYear, publicationMonth, publicationDay);
        this.trackAudioPath = trackAudioPath; //dovrebbe essere un file
    }
    // getters


    public int getCurrentTime() {
        return currentTime;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public String getArtist() {
        return artist;
    }

    public int getTimeLength() {
        return timeLength;
    }

    public String getTitle() {
        return title;
    }
    // setters

    protected void setCurrentTime(int currentTime) {
        this.currentTime = currentTime; // possibiliità di modificare il tempo corrente. il metodo dovrà essere gestito solamente all'interno della classe per evitare che
        //l'informazione possa essere modificata esternamente, causando errori (e.g. superare tempo massimo).
    }

    @Override
    public String toString() {
        return "Title :" + title +
                "\nTime Length=" + timeLength +
                "\nCurrent Time=" + currentTime +
                "\n artist='" + artist + '\'' +
                ", publicationDate=" + publicationDate +
                ", trackAudioPath='" + trackAudioPath + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PlayableItem))return false;
        PlayableItem that = (PlayableItem) obj; // l'istanza that è uguale ad obj castato come PlayableItem
        return this.playableItemId.equals(that.playableItemId);
    }
}