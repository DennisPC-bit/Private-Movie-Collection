package DAL.DAO;

import BE.Song;
import BLL.SongManager;

import java.util.List;
import java.util.Map;

public interface SongDAOInterface {
    /**
     * Sets the song manager
     *
     * @param songManager the song manager
     */
    void setSongManager(SongManager songManager);

    /**
     * Loads all songs
     *
     * @return  A list of songs
     * @throws  Exception If something went wrong
     */
    List<Song> loadSongs() throws Exception;

    /**
     * Creates a new song
     *
     * @param   song the new song
     * @throws  Exception If something went wrong
     */
    void createSong(Song song) throws Exception;

    /**
     * Gets a song
     *
     * @param   name the name of teh song you wanted
     * @return  the song
     * @throws  Exception If something went wrong
     */
    Song getSong(String name) throws Exception;

    /**
     * Deletes a song
     *
     * @param   id the id of the song you want to delete
     * @throws  Exception If something went wrong
     */
    void deleteSong(int id) throws Exception;

    /**
     * modifies a song
     *
     * @param   modified     the modified song
     * @throws  Exception    if something went wrong
     */
    void updateSong(Song modified) throws Exception;

    /**
     * Searches for a string
     *
     * @param   searchQuery     the string you are searching
     * @return                  a list of songs, that matches the searchQuery
     * @throws  Exception       if something went wrong
     */
    List<Song> searchSong(String searchQuery) throws Exception;

    /**
     * Gets the map of genres
     *
     * @return  a map of the genres
     * @throws  Exception if something went wrong
     */
    Map<Integer, String> getGenres() throws Exception;
}