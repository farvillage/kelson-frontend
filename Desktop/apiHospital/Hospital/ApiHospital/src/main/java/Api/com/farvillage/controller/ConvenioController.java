package Api.com.farvillage.controller;

import Api.com.farvillage.model.Consulta;
import Api.com.farvillage.model.Convenio;
import Api.com.farvillage.service.ConvenioService;
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
@RequestMapping("/convenio")
@Tag(name = "Convenio", description = "Endpoints para gerenciar o Convenio")
public class ConvenioController {

    @Autowired
    ConvenioService convenioService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Operation(summary = "Criar Convenio", description = "Criar Convenio",
            tags ={"Convenio"}, responses = {
            @ApiResponse(description = "Success", responseCode = "200",
                    content = @Content(schema = @Schema(implementation = Convenio.class))
            ),
            @ApiResponse(description = "Bad request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
    })
    public void create(@RequestBody Convenio convenio){
        convenioService.create(convenio);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Buscar todos os Convenios", description = "Buscar todos os Convenios",
            tags ={"Convenio"}, responses = {
            @ApiResponse(description = "Success", responseCode = "200",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Convenio.class))
                            )
                    }),
            @ApiResponse(description = "Bad request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
    })
    public List<Convenio> findAll(){
        return convenioService.findAll();
    }
    @GetMapping("/convenio/{id}")
    @Operation(summary = "Encontrar convênio por ID", description = "Retornar convênio por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Encontrado", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "204", description = "Não Encontrado", content = @Content)
    })
    @ResponseStatus(HttpStatus.OK)
    public Optional<Convenio> findById(@PathVariable Long id) {
        return convenioService.findById(id);
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Modificar Convenio por id", description = "Modificar Convenio por ID",
            tags ={"Convenio"}, responses = {
            @ApiResponse(description = "Updated", responseCode = "200",
                    content = @Content(schema = @Schema(implementation = Convenio.class))
            ),
            @ApiResponse(description = "Bad request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
    })
    public void updated(@RequestBody Convenio convenio, @PathVariable Long id){
        convenioService.updated(id, convenio);
    }


    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Deletar Convenio por ID", description = "Deletar Convenio por ID",
            tags ={"Convenio"}, responses = {
            @ApiResponse(description = "Deleted", responseCode = "204", content = @Content),
            @ApiResponse(description = "Bad request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
    })
    public void deleteById(@PathVariable Long id){
        convenioService.DeleteById(id);
    }
}
