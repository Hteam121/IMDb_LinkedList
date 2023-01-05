public class Movie {
    private int date;
    private String title;

    private MyLinkedList<Actor> actors;
    private MyLinkedList<String> directors;

    Movie()
    {
        date = 0;
        title = "";

        actors = new MyLinkedList<>();
        directors = new MyLinkedList<>();
    }

    Movie(int date, String title, MyLinkedList<Actor> actors, MyLinkedList<String> directors)
    {
        this.date = date;
        this.title = title;
        this.actors = actors;
        this.directors = directors;
    }

    int getDate()
    {
        return date;
    }

    String getTitle()
    {
        return title;
    }

    MyLinkedList<Actor> getActors()
    {
        return actors;
    }

    void setActors(MyLinkedList<Actor> actors)
    {
        this.actors = actors;
    }

    MyLinkedList<String> getDirectors()
    {
        return directors;
    }

    @Override
    public String toString()
    {
        String ans = date + " " + title + "\n  Actors:";

        for(int i = 0; i < actors.size(); i++)
        {
            ans += "\n    " + actors.get(i).getName();
        }

        ans +=  "\n  Directors:";

        for(int i = 0; i < directors.size(); i++)
        {
            ans += "\n    " + directors.get(i);
        }

        return ans + "\n";
    }
}
