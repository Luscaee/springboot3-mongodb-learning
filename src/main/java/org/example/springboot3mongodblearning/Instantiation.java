package org.example.springboot3mongodblearning;

import lombok.RequiredArgsConstructor;
import org.example.springboot3mongodblearning.domain.Post;
import org.example.springboot3mongodblearning.domain.User;
import org.example.springboot3mongodblearning.dto.AuthorDto;
import org.example.springboot3mongodblearning.repository.PostRepository;
import org.example.springboot3mongodblearning.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;

@Component
@RequiredArgsConstructor
public class Instantiation implements CommandLineRunner {


    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        postRepository.deleteAll();

        String encryptedPassword = passwordEncoder.encode("123456");

        User maria = new User(null, "Maria Brown", "maria@gmail.com", encryptedPassword);
        User alex = new User(null, "Alex Green", "alex@gmail.com", encryptedPassword);
        User bob = new User(null, "Bob Grey", "bob@gmail.com", encryptedPassword);

        userRepository.saveAll(List.of(maria, alex, bob));

        AuthorDto authorMaria = new AuthorDto(maria.getId(), maria.getName());

        Post post1 = new Post(null, Instant.now(), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", authorMaria);
        Post post2 = new Post(null, Instant.now(), "Bom dia", "Acordei feliz hoje!", authorMaria);

        postRepository.saveAll(List.of(post1, post2));
    }
}
