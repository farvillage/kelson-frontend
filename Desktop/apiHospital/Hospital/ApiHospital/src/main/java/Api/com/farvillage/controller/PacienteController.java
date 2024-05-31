package Api.com.farvillage.controller;

import Api.com.farvillage.model.Paciente;
import Api.com.farvillage.service.PacienteService;
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
@RequestMapping("/pat")
@Tag(name = "Paciente", description = "Endpoints para gerenciar Paciente")
public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Operation(summary = "Criar Paciente", description = "Criar Paciente",
            tags ={"Paciente"}, responses = {
            @ApiResponse(description = "Success", responseCode = "200",
                    content = @Content(schema = @Schema(implementation = Paciente.class))
            ),
            @ApiResponse(description = "Bad request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
    })
    public void create(@RequestBody Paciente paciente){
        pacienteService.create(paciente);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Buscar todos os Pacientes", description = "Buscar todos os Pacientes",
            tags ={"Paciente"}, responses = {
            @ApiResponse(description = "Success", responseCode = "200",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Paciente.class))
                            )
                    }),
            @ApiResponse(description = "Bad request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
    })
    public List<Paciente> findAll(){
        return pacienteService.findAll();
    }
    @GetMapping("/paciente/{id}")
    @Operation(summary = "Encontrar paciente por ID", description = "Buscar paciente por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Encontrado", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "204", description = "nÃO Encontrado", content = @Content)
    })
    @ResponseStatus(HttpStatus.OK)
    public Optional<Paciente> findById(@PathVariable Long id) {
        return pacienteService.findById(id);
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Modificar Paciente por id", description = "Modificar Paciente por ID",
            tags ={"Paciente"}, responses = {
            @ApiResponse(description = "Updated", responseCode = "200",
                    content = @Content(schema = @Schema(implementation = Paciente.class))
            ),
            @ApiResponse(description = "Bad request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
    })
    public void updated(@RequestBody Paciente paciente, @PathVariable Long id){
        pacienteService.updated(id, paciente);
    }


    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Deletar Paciente por ID", description = "Deletar Paciente por ID",
            tags ={"Paciente"}, responses = {
            @ApiResponse(description = "Deleted", responseCode = "204", content = @Content),
            @ApiResponse(description = "Bad request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
    })
    public void deleteById(@PathVariable Long id){
        pacienteService.DeleteById(id);
    }
}
