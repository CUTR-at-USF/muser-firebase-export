

package edu.usf.cutr.mfe.model;

import edu.usf.cutr.mfe.utils.StringUtils;

public class SongMetaDataModel {

	private Integer albumID;
	private String albumName;
	private Integer artistID;
	private String artistName;
	private String bitrateLabel;
	private Double dateAdded;
	private Double discNumber;
	private Double duration;
	private String fileSizeLabel;
	private String formatLabel;
	private Integer id;
	private Double lastPlayed;
	private String name;
	private String path;
	private Integer playCount;
	private Integer playlistID;
	private Integer playlistPlayOrder;
	private Boolean podCast;
	private String sampleRateLabel;
	private Integer track;
	private Integer year;

	public Integer getAlbumID() {
		return albumID;
	}

	public String getAlbumName() {
		return albumName;
	}

	public Integer getArtistID() {
		return artistID;
	}

	public String getArtistName() {
		return artistName;
	}

	public Double getDiscNumber() {
		return discNumber;
	}

	public Double getDuration() {
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

	public Double getLastPlayed() {
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

	public void setAlbumID(Integer albumID) {
		this.albumID = albumID;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public void setArtistID(Integer artistID) {
		this.artistID = artistID;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public void setDiscNumber(Double discNumber) {
		this.discNumber = discNumber;
	}

	public void setDuration(Double duration) {
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

	public void setLastPlayed(Double lastPlayed) {
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

	public Double getDateAdded() {
		return dateAdded;
	}

	public void setBitrateLabel(String bitrateLabel) {
		this.bitrateLabel = bitrateLabel;
	}

	public void setDateAdded(Double dateAdded) {
		this.dateAdded = dateAdded;
	}

	public Integer getPlaylistID() {
		return playlistID;
	}

	public void setPlaylistID(Integer playlistID) {
		this.playlistID = playlistID;
	}

	public String[] toStringArray() {
		return new String[] { StringUtils.valueOf(albumID), albumName, StringUtils.valueOf(artistID), artistName,
				bitrateLabel, StringUtils.valueOf(dateAdded), StringUtils.valueOf(discNumber),
				StringUtils.valueOf(duration), fileSizeLabel, formatLabel, StringUtils.valueOf(id),
				StringUtils.valueOf(lastPlayed), name, path, StringUtils.valueOf(playCount),
				StringUtils.valueOf(playlistID), StringUtils.valueOf(playlistPlayOrder), StringUtils.valueOf(podCast),
				sampleRateLabel, StringUtils.valueOf(track), StringUtils.valueOf(year), };
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
}
