package kodlamaio.hrmsdemo.api.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kodlamaio.hrmsdemo.business.abstracts.FavoriteService;
import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import kodlamaio.hrmsdemo.core.utilities.results.Result;
import kodlamaio.hrmsdemo.entities.concretes.Favorite;
import kodlamaio.hrmsdemo.entities.concretes.Talent;
import kodlamaio.hrmsdemo.entities.dtos.TalentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/favorites")
@Api("Favorite Api Documentation")
@CrossOrigin
public class FavoritesController {

    private FavoriteService favoriteService;
@Autowired
    public FavoritesController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }
    @GetMapping("/getall")
    @ApiOperation("Get All Favorite")
    DataResult<List<Favorite>> getAll() {
        return this.favoriteService.getAll();

    }
    @GetMapping("/getAllFavoritesById")
    @ApiOperation("Get All Favorite By Id")
    DataResult<List<Favorite>> getAllFavoritesById(@RequestParam("id") int id) {
        return this.favoriteService.getAllFavoritesById(id);

    }

    @PostMapping("/add")
    @ApiOperation("Add Favorite")
    public Result add(@Valid @RequestBody Favorite favorite) {

        return this.favoriteService.add(favorite);

    }

}
