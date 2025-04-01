package org.example.deeprice.model.rating;

/**
 *
 * @author Maurice Amon
 */

public abstract class Rating {

    private Integer staffFriendliness;

    private Integer comfortability;

    private Integer cleanilessness;

    private Integer foodQuality;

    public Rating(Integer staffFriendliness, Integer comfortability, Integer cleanilessness, Integer foodQuality) {
        this.staffFriendliness = staffFriendliness;
        this.comfortability = comfortability;
        this.cleanilessness = cleanilessness;
        this.foodQuality = foodQuality;
    }

    public Integer getStaffFriendliness() {
        return staffFriendliness;
    }

    public void setStaffFriendliness(Integer staffFriendliness) {
        this.staffFriendliness = staffFriendliness;
    }

    public Integer getComfortability() {
        return comfortability;
    }

    public void setComfortability(Integer comfortability) {
        this.comfortability = comfortability;
    }

    public Integer getCleanilessness() {
        return cleanilessness;
    }

    public Integer getFoodQuality() {
        return foodQuality;
    }

    public void setFoodQuality(Integer foodQuality) {
        this.foodQuality = foodQuality;
    }
}
