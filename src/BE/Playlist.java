package BE;

import BLL.PlaylistManager;
import javafx.beans.property.*;

public class Playlist {

    private int playlistId;
    private String playListName;
    private StringProperty playListNameProperty;
    protected SimpleDoubleProperty playlistDurationProperty;
    protected SimpleStringProperty playlistDurationStringProperty;
    private ObjectProperty<Integer> playlistSize = new SimpleObjectProperty<>();

    /**
     * Constructor with playlistName
     *
     * @param playListName
     */
    public Playlist(String playListName) {
        initialize();
        setPlayListName(playListName);
    }

    /**
     * Constructor with id and playlistName
     *
     * @param id
     * @param playListName
     */
    public Playlist(int id, String playListName) {
        initialize();
        setPlaylistId(id);
        setPlayListName(playListName);
    }

    /**
     * Constructor with id, playlist name and total duration.
     * @param id
     * @param playListName
     * @param totalDuration
     */
    public Playlist(int id, String playListName, double totalDuration) {
        initialize();
        setPlaylistId(id);
        setPlayListName(playListName);
        setPlaylistDurationProperty(totalDuration);
        setPlaylistDurationStringProperty(totalDuration);
    }

    /**
     * initializes the variables
     */
    private void initialize() {
        playListNameProperty = new SimpleStringProperty();
        playlistDurationProperty = new SimpleDoubleProperty();
        playlistDurationStringProperty = new SimpleStringProperty();
    }

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getPlayListName() {
        return playListName;
    }

    /**
     * Get the value of name property
     *
     * @return the value of name property
     */
    public StringProperty getPlayListNameProperty() {
        return playListNameProperty;
    }

    /**
     * Set the value of name.
     *
     * @param playListName new value of name
     */
    public void setPlayListName(String playListName) {
        this.playListName = playListName;
        this.playListNameProperty.setValue(playListName);
    }

    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public int getPlaylistId() {
        return playlistId;
    }

    /**
     * Set the value of id
     *
     * @param playlistId new value of id
     */
    public void setPlaylistId(int playlistId) {
        this.playlistId = playlistId;
    }

    /**
     * Get the playlist duration string property.
     * @return
     */
    public SimpleStringProperty playlistDurationPropertyString() {
        return playlistDurationStringProperty;
    }

    /**
     * Set the playlist string property. Time gets automatically formatted.
     * @param duration
     */
    public void setPlaylistDurationStringProperty(double duration) {
        var min = (int) duration;
        var sec = (int) duration / 60;
        String str = String.format("%d:%02d", min, sec);
        playlistDurationStringProperty.set(str);
    }

    /**
     * Get the playlist duration property.
     * @return
     */
    public SimpleDoubleProperty playlistDurationProperty() {
        return playlistDurationProperty;
    }

    /**
     * Set the playlist duration property.
     * @param duration
     */
    public void setPlaylistDurationProperty(double duration) {
        playlistDurationProperty.set(duration);
    }

    /**
     * Get the total duration of the playlist.
     * @return
     */
    public double getTotalDuration() {
        return playlistDurationProperty.get();
    }

    /**
     * Get the formatted total duration of the playlist for GUI.
     * @return
     */
    public String getTotalDurationString() {
        return playlistDurationStringProperty.get();
    }

    /**
     * Get the total amount of songs in the playlist.
     * @return
     */
    public ObjectProperty<Integer> getPlaylistSize() {
        PlaylistManager playlistManager = new PlaylistManager();
        try {
            playlistSize.setValue(playlistManager.loadSongsOnPlaylist(this.getPlaylistId()).size());
            return playlistSize;
        } catch (Exception e) {
            e.printStackTrace();
            return new SimpleObjectProperty<>(0);
        }
    }
}
