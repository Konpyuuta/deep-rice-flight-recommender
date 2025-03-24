package org.example.deeprice.model.rating;

/**
 *
 * @author Maurice Amon
 */

public abstract class Rating {

    private Integer staffFriendliness;

    private Integer comfortability;

    private Integer cleanilessness;

    public Rating(Integer staffFriendliness, Integer comfortability, Integer cleanilessness) {
        this.staffFriendliness = staffFriendliness;
        this.comfortability = comfortability;
        this.cleanilessness = cleanilessness;
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
}
