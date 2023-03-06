package com.bozduran.site.bootstrap;

import com.bozduran.site.domain.*;
import com.bozduran.site.repository.AccountCredentialsRepository;
import com.bozduran.site.repository.AccountRepository;
import com.bozduran.site.repository.CommentRepository;
import com.bozduran.site.repository.PostRepository;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
@AllArgsConstructor
@Component
public class BootstrapData implements CommandLineRunner {

    private final AccountRepository accountRepository;
    private final AccountCredentialsRepository accountCredentialsRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Data bootstrapping.");
        //CREATE ACCOUNT
        Account account = new Account();

        account.setFirstName("Duran");
        account.setLastName("Boz");
        account.setEmail("durhfgan@gmail.com");
        account.setDateOfCreation(new Date());
        AccountCredentials accountCredentials = new AccountCredentials();

        //CREATE ACCOUNT CREDENTIALS
        accountCredentials.setUserName("duran123");
        accountCredentials.setPasswordHash("springboot");
        accountCredentials.setDateOfPasswordChange(new Date());
        account.setAccountCredentials(accountCredentials);
        Account savedAccount = accountRepository.save(account);

        //ADD POST TO ACCOUNT
        Post post = new TextPost("This is a simmple post");
        post.setAccount(savedAccount);
        val savedPost = postRepository.save(post);
        savedAccount.addPostToAccount(savedPost);

        //ADD POST TO ACCOUNT
        Account retreivedAccount = accountRepository.getAccountByAccountId(savedAccount.getAccountId());
        Post photoPost = new PhotoPost("new.png");
        photoPost.setAccount(retreivedAccount);
        val p = postRepository.save(photoPost);

        ///ADD COMMENT TO POST
        Post retrievedPost = postRepository.getPostById(p.getId());
        Comment textComment = new TextComment("This is a comment");
        textComment.setPost(retrievedPost);
        retrievedPost.getComments().add(textComment);

        commentRepository.save(textComment);

        System.out.println("Data bootstrapping end.");
    }
}
