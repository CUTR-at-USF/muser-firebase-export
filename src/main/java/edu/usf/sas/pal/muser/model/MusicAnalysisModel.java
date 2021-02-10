
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
import edu.usf.sas.pal.muser.model.MusicAnalysisModel.AudioData.VolumeData;
import edu.usf.sas.pal.muser.utils.StringUtils;

public class MusicAnalysisModel {

    public MusicAnalysisModel() {
    }

    public MusicAnalysisModel(MusicAnalysisModel musicAnalysisModel, String recordId, String userId) {
        this.recordId = recordId;
        this.userId = userId;
        this.song = musicAnalysisModel.getSongData();
        this.album = musicAnalysisModel.getAlbumData();
        this.albumArtist = musicAnalysisModel.getAlbumArtist();
        this.albumArtistData = musicAnalysisModel.getAlbumArtistData();
        this.genre = musicAnalysisModel.getGenreData();
        this.audioData = musicAnalysisModel.getAudioData();
        this.eventPlayerType = musicAnalysisModel.getPlayerEventType();
        this.eventUiType = musicAnalysisModel.getUiEventType();
        this.eventCurrentTimeMs = musicAnalysisModel.getCurrentTimeMs();
        this.eventNanoTime = musicAnalysisModel.getNanoTime();
        this.eventSeekPositionMs = musicAnalysisModel.getSeekPositionMs();
        this.eventStartTime = musicAnalysisModel.getStartTime();
        this.eventElapsedTime = musicAnalysisModel.getElapsedTime();
        this.deviceInfoAppVersion = musicAnalysisModel.getAppVersion();
        this.deviceInfoDeviceModel = musicAnalysisModel.getDeviceModel();
        this.deviceInfoGooglePlayServicesApp = musicAnalysisModel.getGooglePlayServicesApp();
        this.deviceInfoGooglePlayServicesLib = musicAnalysisModel.getGooglePlayServicesLib();
        this.deviceInfoIgnoringBatteryOptimizations = musicAnalysisModel.getIgnoringBatteryOptimizations();
        this.deviceInfoPowerSaveModeEnabled = musicAnalysisModel.getPowerSaveModeEnabled();
        this.deviceInfoSdkVersion = musicAnalysisModel.getSdkVersion();
        this.deviceInfoSdkVersionInt = musicAnalysisModel.getSdkVersionInt();
        this.deviceInfoTalkBackEnabled = musicAnalysisModel.getTalkBackEnabled();
        this.deviceInfoTimestamp = musicAnalysisModel.getTimestamp();
    }

    /**
     * Album Artist Data class to handle PLAY_ALBUM_ARTIST event
     */
    public static class AlbumArtistData {

        public AlbumArtistData() {

        }

        private String name;
        private List<AlbumData> albumData;

        public static class AlbumData {

            public AlbumData() {
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

            public String getAlbumArtistName() {
                return albumArtistName;
            }

            public void setAlbumArtistName(String albumArtistName) {
                this.albumArtistName = albumArtistName;
            }

            public static class Artists {

                public Artists() {

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

                @Override
                public String toString() {
                    return "id=" + id + ", name=" + name + ", numAlbums=" + numAlbums + ", numSongs="
                            + numSongs + "";
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

            @Override
            public String toString() {
                return "AlbumData [albumArtistName=" + albumArtistName + ", artists=" + artists + ", dateAdded="
                        + dateAdded + ", id=" + id + ", name=" + name + ", numDiscs=" + numDiscs + ", numSongs="
                        + numSongs + ", paths=" + paths + ", year=" + year + "]";
            }

        }

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

    public static class AlbumArtist {

        public AlbumArtist() {
        }

        private String name;
        private List<AlbumData> albumData;

        public static class AlbumData {

            public AlbumData() {
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

            public String getAlbumArtistName() {
                return albumArtistName;
            }

            public void setAlbumArtistName(String albumArtistName) {
                this.albumArtistName = albumArtistName;
            }

            public static class Artists {

                public Artists() {
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

                @Override
                public String toString() {
                    return "id=" + id + ", name=" + name + ", numAlbums=" + numAlbums + ", numSongs="
                            + numSongs + "";
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

            @Override
            public String toString() {
                return "AlbumData [albumArtistName=" + albumArtistName + ", artists=" + artists + ", dateAdded="
                        + dateAdded + ", id=" + id + ", name=" + name + ", numDiscs=" + numDiscs + ", numSongs="
                        + numSongs + ", paths=" + paths + ", year=" + year + "]";
            }

        }

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

        @Override
        public String toString() {
            return "AlbumArtist [name=" + name + ", albumData=" + albumData + "]";
        }
    }

    public static class GenreData {

        public GenreData() {
        }

        private Long id;
        private String name;
        private Integer numSong;
        private Integer numSongs;

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

        public Integer getNumSongs() {
            return numSongs;
        }

        public void setNumSongs(Integer numSongs) {
            this.numSongs = numSongs;
        }
    }

    /**
     * SongData class to handle music metadata
     */
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

    /**
     * Album class to handle Album metadata
     */
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

            public Artists() {
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

            @Override
            public String toString() {
                return "id=" + id + ", name=" + name + ", numAlbums=" + numAlbums + ", numSongs="
                        + numSongs + "";
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

    /**
     * Audio Data class to track the volume and output device on which the user is listening to.
     */
    public static class AudioData {

        public AudioData() {

        }

        private String audioDeviceType;
        public VolumeData volumeData;

        public static class VolumeData {
            public int currentVolumeLevel;
            public int volumeMax;
            public int volumeMin;
            public double volumeDB;

            @Override
            public String toString() {
                return "VolumeData [currentVolumeLevel=" + currentVolumeLevel + ", volumeMax=" + volumeMax
                        + ", volumeMin=" + volumeMin + ", volumeDB=" + volumeDB + "]";
            }

            public VolumeData() {
            }

            public double getVolumeDB() {
                return volumeDB;
            }

            public void setVolumeDB(double volumeDB) {
                this.volumeDB = volumeDB;
            }

            public int getCurrentVolumeLevel() {
                return currentVolumeLevel;
            }

            public void setCurrentVolumeLevel(int currentVolumeLevel) {
                this.currentVolumeLevel = currentVolumeLevel;
            }

            public int getVolumeMax() {
                return volumeMax;
            }

            public void setVolumeMax(int volumeMax) {
                this.volumeMax = volumeMax;
            }

            public int getVolumeMin() {
                return volumeMin;
            }

            public void setVolumeMin(int volumeMin) {
                this.volumeMin = volumeMin;
            }
        }

        public VolumeData getVolumeData() {
            return volumeData;
        }

        public void setVolumeData(VolumeData volumeData) {
            this.volumeData = volumeData;
        }

        public String getAudioDeviceType() {
            return audioDeviceType;
        }

        public void setAudioDeviceType(String audioDeviceType) {
            this.audioDeviceType = audioDeviceType;
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


    private String appVersion;

    public String getAppVersion() {
        return appVersion;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public String getGooglePlayServicesApp() {
        return googlePlayServicesApp;
    }

    public Long getGooglePlayServicesLib() {
        return googlePlayServicesLib;
    }

    public Boolean getIgnoringBatteryOptimizations() {
        return ignoringBatteryOptimizations;
    }

    public Boolean getPowerSaveModeEnabled() {
        return powerSaveModeEnabled;
    }

    public String getSdkVersion() {
        return sdkVersion;
    }

    public Long getSdkVersionInt() {
        return sdkVersionInt;
    }

    public Boolean getTalkBackEnabled() {
        return talkBackEnabled;
    }

    public String getTimestamp() {
        return timestamp;
    }

    private String deviceInfoAppVersion;
    private String deviceModel;
    private String deviceInfoDeviceModel;
    private String googlePlayServicesApp;
    private String deviceInfoGooglePlayServicesApp;
    private Long googlePlayServicesLib;
    private Long deviceInfoGooglePlayServicesLib;
    private Boolean ignoringBatteryOptimizations;
    private Boolean deviceInfoIgnoringBatteryOptimizations;
    private Boolean powerSaveModeEnabled;
    private Boolean deviceInfoPowerSaveModeEnabled;
    private String sdkVersion;
    private String deviceInfoSdkVersion;
    private Long sdkVersionInt;
    private Long deviceInfoSdkVersionInt;
    private Boolean talkBackEnabled;
    private Boolean deviceInfoTalkBackEnabled;
    private String timestamp;
    private String deviceInfoTimestamp;
    public SongData song;
    public Album album;
    public AlbumArtistData albumArtistData;
    public GenreData genre;
    public AlbumArtist albumArtist;
    public AudioData audioData;
    public VolumeData volumeData;

    public AlbumArtistData getAlbumArtistData() {
        return albumArtistData;
    }

    public void setAlbumArtistData(AlbumArtistData albumArtistData) {
        this.albumArtistData = albumArtistData;
    }

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

    public AudioData getAudioData() {
        return audioData;
    }

    public void setAudioData(AudioData audioData) {
        this.audioData = audioData;
    }

    /**
     * CSV File headers
     */
    public static final String[] CSV_HEADER = {
            "user_id",
            "record_id",
            "player_event_type",
            "ui_event_type",
            "event_current_time_in_milliseconds",
            "event_nano_time",
            "event_seek_position_in_milliseconds",
            "event_start_time",
            "event_elapsed_time",
            "song_album_id",
            "song_album_name",
            "song_artist_id",
            "song_artist_name",
            "song_bit_rate",
            "song_date_added",
            "song_disc_number",
            "song_duration",
            "song_file_size",
            "song_file_format",
            "song_id",
            "song_last_played",
            "song_name",
            "song_file_path",
            "song_play_count",
            "song_playlist_id",
            "playlist_play_order",
            "podcast",
            "song_sample_rate",
            "track",
            "song_release_year",
            "album_id",
            "album_name",
            "album_artist_name",
            "album_date_added",
            "album_release_year",
            "number_of_songs_in_album",
            "number_of_discs_in_album",
            "album_artists",
            "album_paths",
            "genre_id",
            "genre_name",
            "number_of_songs_for_genre",
            "album_artist_name",
            "album_artist_album_data",
            "audio_devic_type",
            "audio_volume_data",
            "device_info_app_version",
            "device_info_device_model",
            "device_info_google_play_services_app",
            "device_info_google_play_services_lib",
            "device_info_ignoring_battery_optimizations",
            "device_info_power_save_mode_enabled",
            "device_info_sdk_version",
            "device_info_sdk_version_int",
            "device_info_talk_back_enabled",
            "device_info_timestamp",
    };

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

    public MusicAnalysisModel setDeviceInfoAppVersion(String appVersion) {
        deviceInfoAppVersion = appVersion;
        return this;
    }

    public MusicAnalysisModel setDeviceInfoDeviceModel(String deviceModel) {
        deviceInfoDeviceModel = deviceModel;
        return this;
    }

    public MusicAnalysisModel setDeviceInfoGooglePlayServicesApp(String googlePlayServicesApp) {
        deviceInfoGooglePlayServicesApp = googlePlayServicesApp;
        return this;
    }

    public MusicAnalysisModel setDeviceInfoGooglePlayServicesLib(Long googlePlayServicesLib) {
        deviceInfoGooglePlayServicesLib = googlePlayServicesLib;
        return this;
    }

    public MusicAnalysisModel setDeviceInfoIgnoringBatteryOptimizations(Boolean ignoringBatteryOptimizations) {
        deviceInfoIgnoringBatteryOptimizations = ignoringBatteryOptimizations;
        return this;
    }

    public MusicAnalysisModel setDeviceInfoPowerSaveModeEnabled(Boolean powerSaveModeEnabled) {
        deviceInfoPowerSaveModeEnabled = powerSaveModeEnabled;
        return this;
    }

    public MusicAnalysisModel setDeviceInfoSdkVersion(String sdkVersion) {
        deviceInfoSdkVersion = sdkVersion;
        return this;
    }

    public MusicAnalysisModel setDeviceInfoSdkVersionInt(Long sdkVersionInt) {
        deviceInfoSdkVersionInt = sdkVersionInt;
        return this;
    }

    public MusicAnalysisModel setDeviceInfoTalkBackEnabled(Boolean talkBackEnabled) {
        deviceInfoTalkBackEnabled = talkBackEnabled;
        return this;
    }

    public MusicAnalysisModel setDeviceInfoTimestamp(String timestamp) {
        deviceInfoTimestamp = timestamp;
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
                (albumArtist == null || albumArtist.getName() == null ? "" : albumArtist.getName()),
                (albumArtist == null || albumArtist.getAlbumData() == null ? "" : albumArtist.getAlbumData() + ""),
                (audioData == null || audioData.getAudioDeviceType() == null ? "" : audioData.getAudioDeviceType() + ""),
                (audioData == null || audioData.getVolumeData() == null ? "" : audioData.getVolumeData() + ""),
                deviceInfoAppVersion,
                deviceInfoDeviceModel,
                deviceInfoGooglePlayServicesApp,
                StringUtils.valueOf(deviceInfoGooglePlayServicesLib),
                StringUtils.valueOf(deviceInfoIgnoringBatteryOptimizations),
                StringUtils.valueOf(deviceInfoPowerSaveModeEnabled),
                deviceInfoSdkVersion,
                StringUtils.valueOf(deviceInfoSdkVersionInt),
                StringUtils.valueOf(deviceInfoTalkBackEnabled),
                deviceInfoTimestamp,
        };
    }
}

