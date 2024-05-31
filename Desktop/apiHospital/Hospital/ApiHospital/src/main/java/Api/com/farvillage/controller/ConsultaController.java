package Api.com.farvillage.controller;


import Api.com.farvillage.model.Consulta;
import Api.com.farvillage.service.ConsultaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/consulta")
@Tag(name = "Consulta", description = "Endpoints para gerenciar as consultas")
public class ConsultaController {

    @Autowired
    ConsultaService consultaService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Operation(summary = "Criar consulta", description = "Criar consulta",
            tags ={"Consulta"}, responses = {
            @ApiResponse(description = "Success", responseCode = "200",
                    content = @Content(schema = @Schema(implementation = Consulta.class))
            ),
            @ApiResponse(description = "Bad request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
    })
    public void create(@RequestBody Consulta consulta){
        consultaService.create(consulta);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Buscar todas as consultas", description = "Buscar todas as consultas",
            tags ={"Consulta"}, responses = {
            @ApiResponse(description = "Success", responseCode = "200",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Consulta.class))
                            )
                    }),
            @ApiResponse(description = "Bad request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
    })
    public List<Consulta> findAll(){
        return consultaService.findAll();
    }
    @GetMapping("/consulta/{id}")
    @Operation(summary = "Encontrar consulta por ID", description = "Buscar consulta por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Encontrado!", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "204", description = "Não Encontrado", content = @Content)
    })
    @ResponseStatus(HttpStatus.OK)
    public Optional<Consulta> findById(@PathVariable Long id) {
        return consultaService.findById(id);
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Modificar Consulta por id", description = "Modificar Consulta por ID",
            tags ={"Consulta"}, responses = {
            @ApiResponse(description = "Updated", responseCode = "200",
                    content = @Content(schema = @Schema(implementation = Consulta.class))
            ),
            @ApiResponse(description = "Bad request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
    })
    public void updated(@RequestBody Consulta consulta, @PathVariable Long id){
        consultaService.updated(id, consulta);
    }


    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Deletar consulta por ID", description = "Deletar consulta por ID",
            tags ={"Consulta"}, responses = {
            @ApiResponse(description = "Deleted", responseCode = "204", content = @Content),
            @ApiResponse(description = "Bad request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
    })
    public void deleteById(@PathVariable Long id){
        consultaService.DeleteById(id);
    }
}
