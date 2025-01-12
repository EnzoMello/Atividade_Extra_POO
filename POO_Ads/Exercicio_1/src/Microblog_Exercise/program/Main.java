package Microblog_Exercise.program;

import Microblog_Exercise.entities.Microblog;
import Microblog_Exercise.entities.Postagem;

public class Main {
    public static void main(String[] args){
        Microblog microblog = new Microblog();
        Postagem post1 = new Postagem(1,1,"Primeiro post.");
        Postagem post2 = new Postagem(2,1,"Segundo post");
        Postagem post3 = new Postagem(3,1,"Terceiro post");

        microblog.incluirPostagem(post1);
        microblog.incluirPostagem(post2);
        microblog.incluirPostagem(post3);
        System.out.println("Lista de posts adicionados");
        microblog.listarPosts();

        // Excluindo um post
        microblog.excluirPost(2);
        System.out.println("Post 3 excluído.");
        microblog.curtirId(2);
        System.out.println("Post 2 teve mais uma curtida.");
        microblog.listarPosts();
        System.out.println("Post 2: " + microblog.consultaId(1));

    }
}
