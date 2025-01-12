package Microblog_Exercise.entities;

import java.util.ArrayList;
import java.util.List;

public class Microblog {
   private List<Postagem> postagem;

    public Microblog() {
        this.postagem = new ArrayList<Postagem>();
    }

    public void incluirPostagem(Postagem post){
        this.postagem.add(post);
    }

    public void listarPosts(){
        for(Postagem post : postagem){
            System.out.println(post);
        }
    }

    public Postagem consultaId(int indice){
        if(indice > 0 && indice < postagem.size()){
            return postagem.get(indice);
        }
        System.out.println("Post inválida.");
        return null;
    }

    public void excluirPost(int id){
        postagem.remove(consultaId(id));
    }

    public Postagem maisCurtida(){
        Postagem post = new Postagem(0,0,"Mais curtida");
        for(Postagem postagem : postagem){
            if (postagem.getQuantidadeCurtidas() > post.getQuantidadeCurtidas()){
                post = postagem;
            }
        }
        return post;
    }

    public void curtirId(int id){
        for(Postagem post : postagem){
            if(post.getId() == id){
                post.curtir(1);
            }
        }
    }

}
