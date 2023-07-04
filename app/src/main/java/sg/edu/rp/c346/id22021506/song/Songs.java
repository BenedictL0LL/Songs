package sg.edu.rp.c346.id22021506.song;

public class Songs {
    private int id;
    private String song;
    private String singer;
    private int year;
    private int stars;

    public Songs(String title, String singers, int year, int stars) {
        this.song = title;
        this.singer = singers;
        this.year = year;
        this.stars = stars;
    }
    public int get_id() {
        return id;
    }

    public String getSong() {
        return song;
    }

    public String getSingers() {
        return singer;
    }

    public int getYear() {
        return year;
    }

    public int getStars() {
        return stars;
    }

    @Override
    public String toString() {
        String text = String.format("Song Title: %s\nSinger: %s\nYear: %4d\n%1d %5s",song,singer,year,stars);
        return text;
    }

}
