package edu.usf.sas.pal.muser.model;

import edu.usf.sas.pal.muser.utils.StringUtils;

public class MusicAnalysisModel {

    public MusicAnalysisModel() {
    }

    public MusicAnalysisModel(String userId) {
        mUserId = userId;
    }

    public static String[] getCsvHeader() {
        return CSV_HEADER;
    }

    private String mUserId;
    private Double currentTimeMs;
    private Double seekPositionMs;
    private Double nanoTime;
    private String playerEventType;
    private String uiEventType;
    private Long mAlbumID;
    private String mAlbumName;
    private Long mArtistID;
    private String mArtistName;
    private String mBitrateLabel;
    private Double mDateAdded;
    private Double mDiscNumber;
    private Double mDuration;
    private String mFileSizeLabel;
    private String mFormatLabel;
    private Integer mId;
    private Double mLastPlayed;
    private String mName;
    private String mPath;
    private Integer mPlayCount;
    private Integer mPlaylistID;
    private Integer mPlaylistPlayOrder;
    private Boolean mPodCast;
    private String mSampleRateLabel;
    private Integer mTrack;
    private Integer mYear;
    private Double startTime;
    private Double elapsedTime;
    public SongMetaDataModel song;

    public void setmUserId(String mUserId) {
        this.mUserId = mUserId;
    }

    public void setmDateAdded(Double mDateAdded) {
        this.mDateAdded = mDateAdded;
    }

    public void setmDiscNumber(Double mDiscNumber) {
        this.mDiscNumber = mDiscNumber;
    }

    public void setmDuration(Double mDuration) {
        this.mDuration = mDuration;
    }

    public void setmFileSizeLabel(String mFileSizeLabel) {
        this.mFileSizeLabel = mFileSizeLabel;
    }

    public void setmFormatLabel(String mFormatLabel) {
        this.mFormatLabel = mFormatLabel;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public void setmLastPlayed(Double mLastPlayed) {
        this.mLastPlayed = mLastPlayed;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public void setmPath(String mPath) {
        this.mPath = mPath;
    }

    public void setmPlayCount(Integer mPlayCount) {
        this.mPlayCount = mPlayCount;
    }

    public void setmPlaylistID(Integer mPlaylistID) {
        this.mPlaylistID = mPlaylistID;
    }

    public void setmPlaylistPlayOrder(Integer mPlaylistPlayOrder) {
        this.mPlaylistPlayOrder = mPlaylistPlayOrder;
    }

    public void setmPodCast(Boolean mPodCast) {
        this.mPodCast = mPodCast;
    }

    public void setmSampleRateLabel(String mSampleRateLabel) {
        this.mSampleRateLabel = mSampleRateLabel;
    }

    public void setmTrack(Integer mTrack) {
        this.mTrack = mTrack;
    }

    public void setmYear(Integer mYear) {
        this.mYear = mYear;
    }

    public static final String[] CSV_HEADER = {"User ID", "Current Time (nanoseconds)", "Nano Time (milliseconds)",
            "Seek Position (milliseconds)", "Player Event Type", "UI Event Type", "Album ID", "Album Name", "Artist ID", "Artist Name",
            "Bit Rate", "Date Added", "Disc Number", "Duration", "File Size", "File Format", "Song ID", "Last Played",
            "Song Name", "File Path", "Play Count", "Play List ID", "Play List Play Order", "Podcast", "Simple Rate",
            "Track", "Year", "Start Time", "Elapsed Time"};

    public String getUserId() {
        return mUserId;
    }

    public Double getCurrentTimeMs() {
        return currentTimeMs;
    }

    public Double getSeekPositionMs() {
        return seekPositionMs;
    }

    public Double getNanoTime() {
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

    public void setCurrentTimeMs(Double currentTimeMs) {
        this.currentTimeMs = currentTimeMs;
    }

    public void setSeekPositionMs(Double seekPositionMs) {
        this.seekPositionMs = seekPositionMs;
    }

    public void setNanoTime(Double nanoTime) {
        this.nanoTime = nanoTime;
    }

    public void setPlayerEventType(String playerEventType) {
        this.playerEventType = playerEventType;
    }

    public void setmAlbumID(Long mAlbumID) {
        this.mAlbumID = mAlbumID;
    }

    public void setmAlbumName(String mAlbumName) {
        this.mAlbumName = mAlbumName;
    }

    public void setmArtistID(Long mArtistID) {
        this.mArtistID = mArtistID;
    }

    public void setmArtistName(String mArtistName) {
        this.mArtistName = mArtistName;
    }

    public void setmBitrateLabel(String mBitrateLabel) {
        this.mBitrateLabel = mBitrateLabel;
    }

    public Double getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(Double elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public Double getStartTime() {
        return startTime;
    }

    public void setStartTime(Double startTime) {
        this.startTime = startTime;
    }

    public String[] toStringArray() {
        return new String[]{mUserId, StringUtils.valueOf(currentTimeMs), StringUtils.valueOf(nanoTime),
                StringUtils.valueOf(seekPositionMs), playerEventType, uiEventType, StringUtils.valueOf(mAlbumID), mAlbumName,
                StringUtils.valueOf(mArtistID), mArtistName, mBitrateLabel, StringUtils.valueOf(mDateAdded),
                StringUtils.valueOf(mDiscNumber), StringUtils.valueOf(mDuration), mFileSizeLabel, mFormatLabel,
                StringUtils.valueOf(mId), StringUtils.valueOf(mLastPlayed), mName, mPath,
                StringUtils.valueOf(mPlayCount), StringUtils.valueOf(mPlaylistID),
                StringUtils.valueOf(mPlaylistPlayOrder), StringUtils.valueOf(mPodCast), mSampleRateLabel,
                StringUtils.valueOf(mTrack), StringUtils.valueOf(mYear), StringUtils.valueOf(startTime), StringUtils.valueOf(elapsedTime)};
    }


}
