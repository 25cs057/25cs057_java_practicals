package exercise1;

/**
 * Sample SignupForm data transfer model annotated with @NotBlank and @MaxLength.
 */
public class SignupForm {
    @NotBlank(message = "Username cannot be empty")
    @MaxLength(value = 15, message = "Username cannot exceed 15 characters")
    private String username;

    @NotBlank(message = "Password cannot be empty")
    @MaxLength(value = 10, message = "Password cannot exceed 10 characters")
    private String password;

    @NotBlank(message = "Email address is required")
    private String email;

    public SignupForm(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}

