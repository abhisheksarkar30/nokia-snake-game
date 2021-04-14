package edu.abhi.games.nokiasnake;

import edu.abhi.games.nokiasnake.console.Game;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class NokiaSnakeGameApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(NokiaSnakeGameApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Game.main(Arrays.copyOfRange(args, 1, args.length));
		Game.main(args);
	}
}
