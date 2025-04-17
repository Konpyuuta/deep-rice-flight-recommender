package org.example.deeprice.model.rating;

/**
 *
 * @author Maurice Amon
 */

public abstract class Rating {

    private Integer customerService;

    private Integer legRoom;

    private Integer seatComfort;

    private Integer foodQuality;

    public Rating(Integer staffFriendliness, Integer comfortability, Integer cleanilessness, Integer foodQuality) {
        this.customerService = staffFriendliness;
        this.legRoom = comfortability;
        this.seatComfort = cleanilessness;
        this.foodQuality = foodQuality;
    }

    public Integer getCustomerService() {
        return customerService;
    }

    public void setCustomerService(Integer customerService) {
        this.customerService = customerService;
    }

    public Integer getLegRoom() {
        return legRoom;
    }

    public void setLegRoom(Integer legRoom) {
        this.legRoom = legRoom;
    }

    public Integer getSeatComfort() {
        return seatComfort;
    }

    public Integer getFoodQuality() {
        return foodQuality;
    }

    public void setFoodQuality(Integer foodQuality) {
        this.foodQuality = foodQuality;
    }
}
