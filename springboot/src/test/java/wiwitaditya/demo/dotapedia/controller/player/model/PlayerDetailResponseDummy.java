package wiwitaditya.demo.dotapedia.controller.player.model;

public class PlayerDetailResponseDummy {

    public static PlayerDetailResponse get() {
        PlayerDetailResponse pdr = new PlayerDetailResponse();
        pdr.setId(1);
        pdr.setNickName("nick-name");
        pdr.setFullName("full-name");
        pdr.setRoles("roles");
        pdr.setDateOfBirth(1l);
        pdr.setCountry("country");
        pdr.setTotalEarnings("total-earnings");
        pdr.setBiography("bio");
        return pdr;
    }
}
