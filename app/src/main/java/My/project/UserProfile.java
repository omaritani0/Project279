package My.project;

import java.util.List;

public class UserProfile {
    private String userId;
    private String name;
    private String photoUrl;
    private String industry;
    private List<String> interests;
    private String location;
    private int experienceLevel;

    // Default constructor required for calls to DataSnapshot.getValue(UserProfile.class)
    public UserProfile() {}

    // Constructor
    public UserProfile(String userId, String name, String photoUrl, String industry,
                       List<String> interests, String location, int experienceLevel) {
        this.userId = userId;
        this.name = name;
        this.photoUrl = photoUrl;
        this.industry = industry;
        this.interests = interests;
        this.location = location;
        this.experienceLevel = experienceLevel;
    }

    // Getters and Setters
    public String getUserId() { return userId; }
    public String getName() { return name; }
    public String getPhotoUrl() { return photoUrl; }
    public String getIndustry() { return industry; }
    public List<String> getInterests() { return interests; }
    public String getLocation() { return location; }
    public int getExperienceLevel() { return experienceLevel; }

    public void setUserId(String userId) { this.userId = userId; }
    public void setName(String name) { this.name = name; }
    public void setPhotoUrl(String photoUrl) { this.photoUrl = photoUrl; }
    public void setIndustry(String industry) { this.industry = industry; }
    public void setInterests(List<String> interests) { this.interests = interests; }
    public void setLocation(String location) { this.location = location; }
    public void setExperienceLevel(int experienceLevel) { this.experienceLevel = experienceLevel; }


}
