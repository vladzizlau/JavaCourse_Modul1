import by.pvt.api.dto.*;

import java.util.stream.Stream;

public class testDTO {

    public static void main(String[] args) {
        ProductRequest productRequest = new ProductRequest(12, "Apple", "AppleGreen", 1, 4.50);
        System.out.println(productRequest.getId() + " " + productRequest.getNameProduct());

        ProductResponse productResponse = new ProductResponse(13, "banana", "BananaYellow", 2, 6);
        System.out.println(productResponse.getId() + " " + productResponse.getNameProduct());

        UserRequest userRequest = new UserRequest("qwerty", "Vasya", "Pupkins", "07071967");
        System.out.println(userRequest.getLogin() + " " + userRequest.getSurName());

        UserResponse userResponse = new UserResponse(123, "Petya", "Ivanov", " Petya Ivanov", "pop", "Admin");
        System.out.println(userResponse.getFirstName() + " " + userResponse.getRole());

    }
}
