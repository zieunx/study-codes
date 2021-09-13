package com.example.cache;

import com.example.cache.domain.Member;
import com.example.cache.repository.MemberRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static java.util.Arrays.asList;

@SpringBootApplication
public class CacheApplication implements CommandLineRunner {

	private final MemberRepository memberRepository;

	public CacheApplication(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(CacheApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.memberRepository.saveAll(asList(
				new Member("zieun"),
				new Member("leesang"),
				new Member("heecheol"),
				new Member("dongdong")

		));
	}
}
