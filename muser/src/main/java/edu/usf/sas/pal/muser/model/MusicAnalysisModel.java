
/*
 * Copyright (C) 2019-2020 University of South Florida
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package edu.usf.sas.pal.muser.model;

import java.util.List;

import edu.usf.sas.pal.muser.utils.StringUtils;


public class MusicAnalysisModel {

    public MusicAnalysisModel() {
    }


    public static class AlbumArtistData {

        public AlbumArtistData() {
        }
    }

    public static class AlbumArtist {

        public AlbumArtist() {
        }

        public static class AlbumData {

            public AlbumData() {
            }


            public String getAlbumArtistName() {
                return albumArtistName;
            }

            public void setAlbumArtistName(String albumArtistName) {
                this.albumArtistName = albumArtistName;
            }

            private String albumArtistName;
            private List<Artists> artists;
            private Long dateAdded;
            private Long id;
            private String name;
            private Integer numDiscs;
            private Integer numSongs;
            private List<String> paths;
            private Integer year;

            public static class Artists {

                @Override
                public String toString() {
                    return "id=" + id + ", name=" + name + ", numAlbums=" + numAlbums + ", numSongs="
                            + numSongs + "";
                }


                public long id;
                public String name;
                public int numAlbums;
                public int numSongs;

                public long getId() {
                    return id;
                }

                public String getName() {
                    return name;
                }

                public int getNumAlbums() {
                    return numAlbums;
                }

                public int getNumSongs() {
                    return numSongs;
                }

                public void setId(long id) {
                    this.id = id;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public void setNumAlbums(int numAlbums) {
                    this.numAlbums = numAlbums;
                }

                public void setNumSongs(int numSongs) {
                    this.numSongs = numSongs;
                }


                public Artists() {
                }
            }

            public Long getDateAdded() {
                return dateAdded;
            }

            public Long getId() {
                return id;
            }

            public String getName() {
                return name;
            }

            public Integer getNumDiscs() {
                return numDiscs;
            }

            public Integer getNumSongs() {
                return numSongs;
            }

            public List<String> getPaths() {
                return paths;
            }

            public Integer getYear() {
                return year;
            }

            public void setDateAdded(Long dateAdded) {
                this.dateAdded = dateAdded;
            }

            public void setId(Long id) {
                this.id = id;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setNumDiscs(Integer numDiscs) {
                this.numDiscs = numDiscs;
            }

            public void setNumSongs(Integer numSongs) {
                this.numSongs = numSongs;
            }

            public void setPaths(List<String> paths) {
                this.paths = paths;
            }

            public void setYear(Integer year) {
                this.year = year;
            }

            public List<Artists> getArtists() {
                return artists;
            }

            public void setArtists(List<Artists> artists) {
                this.artists = artists;
            }


        }

        private String name;
        private List<AlbumData> albumData;


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<AlbumData> getAlbumData() {
            return albumData;
        }

        public void setAlbumData(List<AlbumData> albumData) {
            this.albumData = albumData;
        }
    }


    public static class GenreData {

        public GenreData() {
        }

        private Long id;
        private String name;
        private Integer numSong;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Integer getNumSong() {
            return numSong;
        }

        public void setNumSong(Integer numSong) {
            this.numSong = numSong;
        }
    }

    public static class SongData {

        public SongData() {
        }

        private Long albumID;
        private String albumName;
        private Long artistID;
        private String artistName;
        private String bitrateLabel;
        private Long dateAdded;
        private Long discNumber;
        private Long duration;
        private String fileSizeLabel;
        private String formatLabel;
        private Integer id;
        private Long lastPlayed;
        private String name;
        private String path;
        private Integer playCount;
        private Integer playlistID;
        private Integer playlistPlayOrder;
        private Boolean podCast;
        private String sampleRateLabel;
        private Integer track;
        private Integer year;

        public Long getAlbumID() {
            return albumID;
        }

        public String getAlbumName() {
            return albumName;
        }

        public Long getArtistID() {
            return artistID;
        }

        public String getArtistName() {
            return artistName;
        }

        public Long getDiscNumber() {
            return discNumber;
        }

        public Long getDuration() {
            return duration;
        }

        public String getFileSizeLabel() {
            return fileSizeLabel;
        }

        public String getFormatLabel() {
            return formatLabel;
        }

        public Integer getId() {
            return id;
        }

        public Long getLastPlayed() {
            return lastPlayed;
        }

        public String getName() {
            return name;
        }

        public String getPath() {
            return path;
        }

        public Integer getPlayCount() {
            return playCount;
        }

        public String getSampleRateLabel() {
            return sampleRateLabel;
        }

        public Integer getTrack() {
            return track;
        }

        public Integer getYear() {
            return year;
        }

        public void setAlbumID(Long albumID) {
            this.albumID = albumID;
        }

        public void setAlbumName(String albumName) {
            this.albumName = albumName;
        }

        public void setArtistID(Long artistID) {
            this.artistID = artistID;
        }

        public void setArtistName(String artistName) {
            this.artistName = artistName;
        }

        public void setDiscNumber(Long discNumber) {
            this.discNumber = discNumber;
        }

        public void setDuration(Long duration) {
            this.duration = duration;
        }

        public void setFileSizeLabel(String fileSizeLabel) {
            this.fileSizeLabel = fileSizeLabel;
        }

        public void setFormatLabel(String formatLabel) {
            this.formatLabel = formatLabel;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public void setLastPlayed(Long lastPlayed) {
            this.lastPlayed = lastPlayed;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public void setPlayCount(Integer playCount) {
            this.playCount = playCount;
        }

        public void setSampleRateLabel(String sampleRateLabel) {
            this.sampleRateLabel = sampleRateLabel;
        }

        public void setTrack(Integer track) {
            this.track = track;
        }

        public void setYear(Integer year) {
            this.year = year;
        }

        public String getBitrateLabel() {
            return bitrateLabel;
        }

        public Long getDateAdded() {
            return dateAdded;
        }

        public void setBitrateLabel(String bitrateLabel) {
            this.bitrateLabel = bitrateLabel;
        }

        public void setDateAdded(Long dateAdded) {
            this.dateAdded = dateAdded;
        }

        public Integer getPlaylistID() {
            return playlistID;
        }

        public void setPlaylistID(Integer playlistID) {
            this.playlistID = playlistID;
        }


        public Integer getPlaylistPlayOrder() {
            return playlistPlayOrder;
        }

        public void setPlaylistPlayOrder(Integer playlistPlayOrder) {
            this.playlistPlayOrder = playlistPlayOrder;
        }

        public Boolean getPodCast() {
            return podCast;
        }

        public void setPodCast(Boolean podCast) {
            this.podCast = podCast;
        }

        public String[] toStringArray() {
            return new String[]{StringUtils.valueOf(albumID), albumName, StringUtils.valueOf(artistID), artistName,
                    bitrateLabel, StringUtils.valueOf(dateAdded), StringUtils.valueOf(discNumber),
                    StringUtils.valueOf(duration), fileSizeLabel, formatLabel, StringUtils.valueOf(id),
                    StringUtils.valueOf(lastPlayed), name, path, StringUtils.valueOf(playCount),
                    StringUtils.valueOf(playlistID), StringUtils.valueOf(playlistPlayOrder), StringUtils.valueOf(podCast),
                    sampleRateLabel, StringUtils.valueOf(track), StringUtils.valueOf(year),};
        }


    }

    public static class Album {

        public Album() {
        }

        private String albumArtistName;
        private List<Artists> artists;
        private Long dateAdded;
        private Long id;
        private String name;
        private Integer numDiscs;
        private Integer numSongs;
        private List<String> paths;
        private Integer year;


        public List<String> getPaths() {
            return paths;
        }

        public void setPaths(List<String> paths) {
            this.paths = paths;
        }

        public List<Artists> getArtists() {
            return artists;
        }

        public void setArtists(List<Artists> artists) {
            this.artists = artists;
        }

        public static class Artists {

            @Override
            public String toString() {
                return "id=" + id + ", name=" + name + ", numAlbums=" + numAlbums + ", numSongs="
                        + numSongs + "";
            }


            public long id;
            public String name;
            public int numAlbums;
            public int numSongs;

            public long getId() {
                return id;
            }

            public String getName() {
                return name;
            }

            public int getNumAlbums() {
                return numAlbums;
            }

            public int getNumSongs() {
                return numSongs;
            }

            public void setId(long id) {
                this.id = id;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setNumAlbums(int numAlbums) {
                this.numAlbums = numAlbums;
            }

            public void setNumSongs(int numSongs) {
                this.numSongs = numSongs;
            }


            public Artists() {
            }
        }

        public Long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getAlbumArtistName() {
            return albumArtistName;
        }

        public Integer getNumSongs() {
            return numSongs;
        }

        public Integer getNumDiscs() {
            return numDiscs;
        }

        public Long getDateAdded() {
            return dateAdded;
        }

        public Integer getYear() {
            return year;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAlbumArtistName(String albumArtistName) {
            this.albumArtistName = albumArtistName;
        }

        public void setNumSongs(Integer numSongs) {
            this.numSongs = numSongs;
        }

        public void setNumDiscs(Integer numDiscs) {
            this.numDiscs = numDiscs;
        }

        public void setDateAdded(Long dateAdded) {
            this.dateAdded = dateAdded;
        }

        public void setYear(Integer year) {
            this.year = year;
        }

    }

    public static String[] getCsvHeader() {
        return CSV_HEADER;
    }

    private String userId;
    private String recordId;
    private Long eventCurrentTimeMs;
    private Long currentTimeMs;
    private Long eventNanoTime;
    private Long nanoTime;
    private Long eventSeekPositionMs;
    private Long seekPositionMs;
    private String eventPlayerType;
    private String playerEventType;
    private String eventUiType;
    private String uiEventType;
    private Long eventElapsedTime;
    private Long elapsedTime;
    private Long eventStartTime;
    private Long startTime;
    public SongData song;
    public Album album;
    public AlbumArtistData albumArtistData;

    public AlbumArtistData getAlbumArtistData() {
        return albumArtistData;
    }

    public void setAlbumArtistData(AlbumArtistData albumArtistData) {
        this.albumArtistData = albumArtistData;
    }

    public GenreData genre;
    public AlbumArtist albumArtist;


    public AlbumArtist getAlbumArtist() {
        return albumArtist;
    }

    public void setAlbumArtist(AlbumArtist albumArtist) {
        this.albumArtist = albumArtist;
    }


    public GenreData getGenreData() {
        return genre;
    }

    public void setGenreData(GenreData genre) {
        this.genre = genre;
    }


    public SongData getSongData() {
        return song;
    }

    public void setSongData(SongData song) {
        this.song = song;
    }

    public Album getAlbumData() {
        return album;
    }

    public void setAlbumData(Album album) {
        this.album = album;
    }

    public static final String[] CSV_HEADER = {
            "User ID", "Record ID", "Player Event Type", "UI Event Type",
            "Event Current Time (nanoseconds)", "Nano Time (milliseconds)",
            "Event Seek Position (milliseconds)", "Event Start Time", "Event Elapsed Time",
            "Song Album ID", "Song Album Name", "Song Artist ID", "Song Artist Name",
            "Song Bit Rate", "Song Date Added", "Song Disc Number", "Song Duration",
            "Song File Size", "Song File Format", "Song ID", "Song Last Played",
            "Song Name", "Song File Path", "Song Play Count", "Song PlayList ID",
            "PlayList Play Order", "Podcast", "Song Simple Rate",
            "Track", "Song Release Year", "Album Artist Name", "Album ID",
            "Album Name", "Album Artist Name", "Album Date Added", "Album Release Year",
            " Number Of Songs in Album ", " Number Of Discs In Album", "Album Artists",
            "Album Paths", "Genre ID", "Genre Name", "Number Of Songs For Genre",};


    public Long getSeekPositionMs() {
        return seekPositionMs;
    }

    public Long getNanoTime() {
        return nanoTime;
    }

    public String getPlayerEventType() {
        return playerEventType;
    }

    public String getUiEventType() {
        return uiEventType;
    }

    public void setUiEventType(String uiEventType) {
        this.uiEventType = uiEventType;
    }


    public void setSeekPositionMs(Long seekPositionMs) {
        this.seekPositionMs = seekPositionMs;
    }

    public void setNanoTime(Long nanoTime) {
        this.nanoTime = nanoTime;
    }

    public void setPlayerEventType(String playerEventType) {
        this.playerEventType = playerEventType;
    }


    public Long getElapsedTime() {
        return elapsedTime;
    }


    public Long getStartTime() {
        return startTime;
    }


    public Long getCurrentTimeMs() {
        return currentTimeMs;
    }

    public String getRecordId() {
        return recordId;
    }


    public void setUserId(String userId) {
        this.userId = userId;
    }


    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public MusicAnalysisModel setEventCurrentTimeMs(Long currentTimeMs) {
        eventCurrentTimeMs = currentTimeMs;
        return this;
    }

    public MusicAnalysisModel setEventSeekPositionMs(Long seekPositionMs) {
        eventSeekPositionMs = seekPositionMs;
        return this;
    }

    public MusicAnalysisModel setEventNanoTime(Long seekPositionMs) {
        eventNanoTime = seekPositionMs;
        return this;
    }

    public MusicAnalysisModel setEventPlayerType(String playerEventType) {
        eventPlayerType = playerEventType;
        return this;
    }

    public MusicAnalysisModel setEventUiType(String uiEventType) {
        eventUiType = uiEventType;
        return this;
    }

    public MusicAnalysisModel setEventStartTime(Long startTime) {
        eventStartTime = startTime;
        return this;
    }

    public MusicAnalysisModel setEventElapsedTime(Long elapsedTime) {
        eventElapsedTime = elapsedTime;
        return this;
    }


    public String[] toStringArray() {
        return new String[]{
                userId,
                recordId,
                eventPlayerType,
                eventUiType,
                StringUtils.valueOf(eventCurrentTimeMs),
                StringUtils.valueOf(eventNanoTime),
                StringUtils.valueOf(eventSeekPositionMs),
                StringUtils.valueOf(eventStartTime),
                StringUtils.valueOf(eventElapsedTime),
                (song == null || song.getAlbumID() == null ? "" : song.getAlbumID() + ""),
                (song == null || song.getAlbumName() == null ? "" : song.getAlbumName()),
                (song == null || song.getArtistID() == null ? "" : song.getArtistID() + ""),
                (song == null || song.getArtistName() == null ? "" : song.getArtistName() + ""),
                (song == null || song.getBitrateLabel() == null ? "" : song.getBitrateLabel()),
                (song == null || song.getDateAdded() == null ? "" : song.getDateAdded() + ""),
                (song == null || song.getDiscNumber() == null ? "" : song.getDiscNumber() + ""),
                (song == null || song.getDuration() == null ? "" : song.getDuration() + ""),
                (song == null || song.getFileSizeLabel() == null ? "" : song.getFileSizeLabel()),
                (song == null || song.getFormatLabel() == null ? "" : song.getFormatLabel()),
                (song == null || song.getId() == null ? "" : song.getId() + ""),
                (song == null || song.getLastPlayed() == null ? "" : song.getLastPlayed() + ""),
                (song == null || song.getName() == null ? "" : song.getName()),
                (song == null || song.getPath() == null ? "" : song.getPath()),
                (song == null || song.getPlayCount() == null ? "" : song.getPlayCount() + ""),
                (song == null || song.getPlaylistID() == null ? "" : song.getPlaylistID() + ""),
                (song == null || song.getPlaylistPlayOrder() == null ? "" : song.getPlaylistPlayOrder() + ""),
                (song == null || song.getPodCast() == null ? "" : song.getPodCast() + ""),
                (song == null || song.getSampleRateLabel() == null ? "" : song.getSampleRateLabel()),
                (song == null || song.getTrack() == null ? "" : song.getTrack() + ""),
                (song == null || song.getYear() == null ? "" : song.getYear() + ""),
                (albumArtist == null || albumArtist.getName() == null ? "" : albumArtist.getName()),
                (album == null || album.getId() == null ? "" : album.getId() + ""),
                (album == null || album.getName() == null ? "" : album.getName()),
                (album == null || album.getAlbumArtistName() == null ? "" : album.getAlbumArtistName()),
                (album == null || album.getDateAdded() == null ? "" : album.getDateAdded() + ""),
                (album == null || album.getYear() == null ? "" : album.getYear() + ""),
                (album == null || album.getNumSongs() == null ? "" : album.getNumSongs() + ""),
                (album == null || album.getNumDiscs() == null ? "" : album.getNumDiscs() + ""),
                (album == null || album.getArtists() == null ? "" : album.getArtists() + ""),
                (album == null || album.getPaths() == null ? "" : album.getPaths() + ""),
                (genre == null || genre.getId() == null ? "" : genre.getId() + ""),
                (genre == null || genre.getName() == null ? "" : genre.getName()),
                (genre == null || genre.getNumSong() == null ? "" : genre.getNumSong() + ""),

        };
    }


    public MusicAnalysisModel(MusicAnalysisModel musicAnalysisModel, String recordId, String userId) {
        this.recordId = recordId;
        this.userId = userId;
        this.song = musicAnalysisModel.getSongData();
        this.album = musicAnalysisModel.getAlbumData();
        this.albumArtist = musicAnalysisModel.getAlbumArtist();
        this.albumArtistData = musicAnalysisModel.getAlbumArtistData();
        this.genre = musicAnalysisModel.getGenreData();
        this.eventPlayerType = musicAnalysisModel.getPlayerEventType();
        this.eventUiType = musicAnalysisModel.getUiEventType();
        this.eventCurrentTimeMs = musicAnalysisModel.getCurrentTimeMs();
        this.eventNanoTime = musicAnalysisModel.getNanoTime();
        this.eventSeekPositionMs = musicAnalysisModel.getSeekPositionMs();
        this.eventStartTime = musicAnalysisModel.getStartTime();
        this.eventElapsedTime = musicAnalysisModel.getElapsedTime();
    }
}

