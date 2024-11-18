package com.ramoslarissa.workshopmongo.config;

import com.ramoslarissa.workshopmongo.domain.Post;
import com.ramoslarissa.workshopmongo.domain.User;
import com.ramoslarissa.workshopmongo.repositories.PostRepository;
import com.ramoslarissa.workshopmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para SP. Abraços!", maria);
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia!", "Hoje acordei feliz!", maria);

        userRepository.saveAll(Arrays.asList(maria, alex, bob));
        postRepository.saveAll(Arrays.asList(post1, post2));
    }
}
