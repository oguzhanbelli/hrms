package kodlamaio.hrmsdemo.api.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kodlamaio.hrmsdemo.business.abstracts.TalentService;
import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import kodlamaio.hrmsdemo.core.utilities.results.Result;
import kodlamaio.hrmsdemo.entities.concretes.JobExperience;
import kodlamaio.hrmsdemo.entities.concretes.Talent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/talents")
@Api("Talent Api Documentation")
public class TalentsController {


    private TalentService talentService;

    @Autowired
    public TalentsController(TalentService talentService) {
        this.talentService = talentService;
    }

    @GetMapping("/getall")
    @ApiOperation("Get All Talent")
    DataResult<List<Talent>> getAll() {
        return this.talentService.getAll();

    }

    @PostMapping("/add")
    @ApiOperation("Add Talent")
    public Result add(@Valid @RequestBody Talent talent) {

        return this.talentService.add(talent);

    }

}
