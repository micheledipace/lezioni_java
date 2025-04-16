package SpotifyItems;

import utils.Genre;

public class Music extends PlayableItem {
    private Genre genre;
    private String equalizationMode;

    public Music(){
        super(); // richiamare la classe padre
        genre = Genre.POP;
        equalizationMode = "Standard";
    }

    public Music (Genre genre, String equalizationMode, String playableItemId, String title, int timeLength, String artist, int publicationYear, int publicationDay, int publicationMonth, String trackAudioPath ){
       super(playableItemId, title, timeLength, artist, publicationYear, publicationDay, publicationMonth, trackAudioPath);
       this.genre = genre;
       this.equalizationMode = equalizationMode;
    }
    public Genre getGenre(){
        return genre;
    }

    public String getEqualizationMode() {
        return equalizationMode;
    }

    public void setEqualizationMode(String equalizationMode) {
        this.equalizationMode = equalizationMode;
    }

    // sicuramente i brani saranno univoci tra loro (abbiamo un ID univoco apposta). perciò non sarà necessario implementare un Override dell'equals della classe padre
    @Override
    public String toString(){
        String tmp = super.toString();
        switch(genre){
            case POP -> tmp+="\nGenre: Pop";
            case JAZZ -> tmp+="\nGenre: Jazz";
            case ROCK -> tmp+="\nGenre: Rock";
            case TRAP -> tmp+="\nGenre: Trap";
            case INDIE -> tmp+="\nGenre: Indie";
        }
        tmp+="\n Equalization Mode: " + equalizationMode;
        return tmp;
    }
}
