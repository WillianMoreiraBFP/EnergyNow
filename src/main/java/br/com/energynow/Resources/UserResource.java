package br.com.energynow.Resources;

import br.com.energynow.Service.UserService;
import br.com.energynow.model.User;
import br.com.energynow.model.user.User;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.sql.SQLException;


@Path("usuarios")
public class UserResource {

    @Path("cadastro")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response cadastrar(User user) {
        UserService userService = new UserService ();

        try{
            user = userService.cadastro (user);
            return Response.ok (user).build ();

        } catch (SQLException e) {
            if (e.getErrorCode () == 1) {
                return Response.status (Response.Status.CONFLICT)
                        .entity ("{\"error\":\"Usuário já cadastrado.\"}")
                        .build ();
            } else {
                return Response.status (Response.Status.INTERNAL_SERVER_ERROR)
                        .entity ("{\"error\":\"Erro inesperado: " + e.getMessage () + "\"}")
                        .build ();
            }
        }
    }

    @POST
    @Path("login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(User user) {
        UserService userService = new UserService ();

        try {
            user = userService.login (user);

            return Response.ok(user).build();
        }catch (SQLException e) {
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity("{\"error\":\"Usuário não encontrado ou senha incorreta.\"}")
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{\"error\":\"Erro inesperado: " + e.getMessage() + "\"}")
                    .build();
        }
    }





}
