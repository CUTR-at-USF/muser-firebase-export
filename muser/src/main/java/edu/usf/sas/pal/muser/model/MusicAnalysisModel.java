
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

import edu.usf.sas.pal.muser.utils.StringUtils;


public class MusicAnalysisModel {
    public MusicAnalysisModel() {
    }

    public static class SongInfoList {

        public SongInfoList() {
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


    public static String[] getCsvHeader() {
        return CSV_HEADER;
    }


    private String UserId;
    private String RecordId;
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
    private Long AlbumId;
    private String AlbumName;
    private Long ArtistId;
    private String ArtistName;
    private String BitrateLabel;
    private Long DateAdded;
    private Long DiscNumber;
    private Long songDuration;
    private String FileSizeLabel;
    private String FormatLabel;
    private Integer SongId;
    private Long LastPlayed;
    private String songName;
    private String songFilePath;
    private Integer PlayCount;
    private Integer PlaylistID;
    private Integer PlaylistPlayOrder;
    private Boolean PodCast;
    private String SampleRateLabel;
    private Integer Track;
    private Integer songReleaseYear;
    private Long eventStartTime;
    private Long startTime;
    private Long eventElapsedTime;
    private Long elapsedTime;
    public SongInfoList song;

    public SongInfoList getSongInfoList() {
        return song;
    }

    public void setSongInfoList(SongInfoList song) {
        this.song = song;
    }

    public static final String[] CSV_HEADER = {"User ID", "Record ID", "Player Event Type", "UI Event Type", "Current Time (nanoseconds)", "Nano Time (milliseconds)",
            "Seek Position (milliseconds)", "Album ID", "Album Name", "Artist ID", "Artist Name",
            "Bit Rate", "Date Added", "Disc Number", "Duration", "File Size", "File Format", "Song ID", "Last Played",
            "Song Name", "File Path", "Play Count", "Play List ID", "Play List Play Order", "Podcast", "Simple Rate",
            "Track", "Year", "Start Time", "Elapsed Time"};


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
        return RecordId;
    }


    public void setUserId(String userId) {
        UserId = userId;
    }


    public void setRecordId(String recordId) {
        RecordId = recordId;
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


    public MusicAnalysisModel setSongFilePath(String path) {
        songFilePath = path;
        return this;
    }

    public MusicAnalysisModel setAlbumId(Long albumID) {
        AlbumId = albumID;
        return this;
    }

    public MusicAnalysisModel setAlbumName(String albumName) {
        AlbumName = albumName;
        return this;
    }

    public MusicAnalysisModel setArtistId(Long artistID) {
        ArtistId = artistID;
        return this;
    }

    public MusicAnalysisModel setArtistName(String artistName) {
        ArtistName = artistName;
        return this;
    }

    public MusicAnalysisModel setBitrateLabel(String bitrateLabel) {
        BitrateLabel = bitrateLabel;
        return this;
    }

    public MusicAnalysisModel setDateAdded(Long dateAdded) {
        DateAdded = dateAdded;
        return this;
    }

    public MusicAnalysisModel setDiscNumber(Long discNumber) {
        DiscNumber = discNumber;
        return this;
    }

    public MusicAnalysisModel setSongDuration(Long duration) {
        songDuration = duration;
        return this;
    }

    public MusicAnalysisModel setFileSizeLabel(String fileSizeLabel) {
        FileSizeLabel = fileSizeLabel;
        return this;
    }

    public MusicAnalysisModel setFormatLabel(String formatLabel) {
        FormatLabel = formatLabel;
        return this;
    }

    public MusicAnalysisModel setSongId(Integer id) {
        SongId = id;
        return this;
    }


    public MusicAnalysisModel setLastPlayed(Long lastPlayed) {
        LastPlayed = lastPlayed;
        return this;
    }


    public MusicAnalysisModel setSongName(String name) {
        songName = name;
        return this;
    }

    public MusicAnalysisModel setPlayCount(Integer playCount) {
        PlayCount = playCount;
        return this;
    }

    public MusicAnalysisModel setPlaylistID(Integer playlistID) {
        PlaylistID = playlistID;
        return this;
    }

    public MusicAnalysisModel setPlaylistPlayOrder(Integer playlistPlayOrder) {
        PlaylistPlayOrder = playlistPlayOrder;
        return this;
    }

    public MusicAnalysisModel setPodCast(Boolean podCast) {
        PodCast = podCast;
        return this;
    }

    public MusicAnalysisModel setSampleRateLabel(String sampleRateLabel) {
        SampleRateLabel = sampleRateLabel;
        return this;
    }


    public MusicAnalysisModel setTrack(Integer track) {
        Track = track;
        return this;
    }

    public MusicAnalysisModel setReleaseYear(Integer year) {
        songReleaseYear = year;
        return this;
    }


    public MusicAnalysisModel setEventStartTime(Long startTime) {
        eventStartTime = startTime;
        return this;
    }

    public MusicAnalysisModel setEventEslapsedTime(Long elapsedTime) {
        eventElapsedTime = elapsedTime;
        return this;
    }


    public String[] toStringArray() {
        return new String[]{UserId, RecordId, eventPlayerType, eventUiType, StringUtils.valueOf(eventCurrentTimeMs), StringUtils.valueOf(eventNanoTime),
                StringUtils.valueOf(eventSeekPositionMs), StringUtils.valueOf(AlbumId), AlbumName,
                StringUtils.valueOf(ArtistId), ArtistName, BitrateLabel, StringUtils.valueOf(DateAdded),
                StringUtils.valueOf(DiscNumber), StringUtils.valueOf(songDuration), FileSizeLabel, FormatLabel,
                StringUtils.valueOf(SongId), StringUtils.valueOf(LastPlayed), songName, songFilePath,
                StringUtils.valueOf(PlayCount), StringUtils.valueOf(PlaylistID),
                StringUtils.valueOf(PlaylistPlayOrder), StringUtils.valueOf(PodCast), SampleRateLabel,
                StringUtils.valueOf(Track), StringUtils.valueOf(songReleaseYear), StringUtils.valueOf(eventStartTime), StringUtils.valueOf(eventElapsedTime)};
    }

    public MusicAnalysisModel(MusicAnalysisModel musicAnalysisModel, String recordId, String userId) {
        this.RecordId = recordId;
        this.UserId = userId;
        this.song = musicAnalysisModel.getSongInfoList();
        this.eventPlayerType = musicAnalysisModel.getPlayerEventType();
        this.eventUiType = musicAnalysisModel.getUiEventType();
        this.eventCurrentTimeMs = musicAnalysisModel.getCurrentTimeMs();
        this.eventNanoTime = musicAnalysisModel.getNanoTime();
        this.eventSeekPositionMs = musicAnalysisModel.getSeekPositionMs();
        this.eventStartTime = musicAnalysisModel.getStartTime();
        this.eventElapsedTime = musicAnalysisModel.getElapsedTime();
        this.AlbumId = song.getAlbumID();
        this.AlbumName = song.getAlbumName();
        this.ArtistId = song.getArtistID();
        this.AlbumName = song.getArtistName();
        this.BitrateLabel = song.getBitrateLabel();
        this.DateAdded = song.getDateAdded();
        this.DiscNumber = song.getDiscNumber();
        this.songDuration = song.getDuration();
        this.FileSizeLabel = song.getFileSizeLabel();
        this.FormatLabel = song.getFormatLabel();
        this.SongId = song.getId();
        this.LastPlayed = song.getLastPlayed();
        this.songName = song.getName();
        this.songFilePath = song.getPath();
        this.PlayCount = song.getPlayCount();
        this.PlaylistID = song.getPlaylistID();
        this.PlaylistPlayOrder = song.getPlaylistPlayOrder();
        this.PodCast = song.getPodCast();
        this.SampleRateLabel = song.getSampleRateLabel();
        this.Track = song.getTrack();
        this.songReleaseYear = song.getYear();

    }


}

