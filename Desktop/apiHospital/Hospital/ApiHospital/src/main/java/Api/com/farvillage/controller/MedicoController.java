package Api.com.farvillage.controller;

import Api.com.farvillage.model.Medico;
import Api.com.farvillage.service.MedicoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.tomcat.util.http.parser.MediaTypeCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/med")
@Tag(name = "Medico", description = "Endpoints para gerenciar Medico")
public class MedicoController {

    @Autowired
    MedicoService medicoService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Operation(summary = "Criar Medico", description = "Criar Medico",
            tags ={"Medico"}, responses = {
            @ApiResponse(description = "Success", responseCode = "200",
                    content = @Content(schema = @Schema(implementation = Medico.class))
            ),
            @ApiResponse(description = "Bad request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
    })
    public void create(@RequestBody Medico medico){
        medicoService.create(medico);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Buscar todos os Medicos", description = "Buscar médico",
            tags ={"Medico"}, responses = {
            @ApiResponse(description = "Success", responseCode = "200",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Medico.class))
                            )
                    }),
            @ApiResponse(description = "Bad request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
    })
    public List<Medico> findAll(){
        return medicoService.findAll();
    }
    @GetMapping("/medico/{id}")
    @Operation(summary = "Encontrar o médico por ID", description = "Buscar o médico")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Encontrado", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "204", description = "Não Encontrado", content = @Content)
    })
    @ResponseStatus(HttpStatus.OK)
    public Optional<Medico> findById(@PathVariable Long id) {
        return medicoService.findById(id);
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Modificar Medico por id", description = "Modificar Medico por ID",
            tags ={"Medico"}, responses = {
            @ApiResponse(description = "Updated", responseCode = "200",
                    content = @Content(schema = @Schema(implementation = Medico.class))
            ),
            @ApiResponse(description = "Bad request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
    })
    public void updated( @RequestBody Medico medico, @PathVariable Long id){
        medicoService.updated(id, medico);
    }


    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Deletar Medico por ID", description = "Deletar Medico por ID",
            tags ={"Medico"}, responses = {
            @ApiResponse(description = "Deleted", responseCode = "204", content = @Content),
            @ApiResponse(description = "Bad request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
    })
    public void deleteById(@PathVariable Long id){
        medicoService.DeleteById(id);
    }


}
