package kodlamaio.hrmsdemo.api.controllers;

import io.swagger.annotations.ApiOperation;
import kodlamaio.hrmsdemo.business.abstracts.AdvertisementService;
import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import kodlamaio.hrmsdemo.core.utilities.results.ErrorDataResult;
import kodlamaio.hrmsdemo.entities.concretes.Advertisement;
import kodlamaio.hrmsdemo.entities.dtos.AdvertisementDto;
import kodlamaio.hrmsdemo.entities.dtos.AdvertisementRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/adversitements/")
@CrossOrigin
public class AdvertisementsController {

    @Autowired
    private AdvertisementService advertisementService;

    public AdvertisementsController(AdvertisementService advertisementService) {
        this.advertisementService = advertisementService;
    }

    @GetMapping("/getAllAd")
    @ApiOperation(value = "Get Byid Method")
    DataResult<List<AdvertisementDto>> getAllAd() {
        return this.advertisementService.getAllAd();

    }

    @PostMapping("/addAd")
    @ApiOperation(value = "Add AD Method")
    ResponseEntity<?> add(@Valid @RequestBody AdvertisementRequestDto advertisement) {
        return ResponseEntity.ok(this.advertisementService.addAd(advertisement)) ;

    }
    @GetMapping("/getActive")
    @ApiOperation(value = "get Actv Method")
    DataResult<List<AdvertisementDto>> getActive() {
        return this.advertisementService.getActive();

    }
    @GetMapping("/getAllPassive")
    @ApiOperation(value = "get Passive Method")
    DataResult<List<AdvertisementDto>> getAllPassive() {
        return this.advertisementService.getAllPassive();

    }
    @GetMapping("/getActiveandEmp")
    @ApiOperation(value = "get emp Method")
    DataResult<List<AdvertisementDto>> getEmpId(@RequestParam int id) {
        return this.advertisementService.getEmpId(id);

    }

    @GetMapping("/getActiveAndDate")
    @ApiOperation(value = "get emp Method")
    DataResult<List<AdvertisementDto>> getAdDate() {
        return this.advertisementService.getAdDate();

    }
    @PutMapping("/updateActive")
    @ApiOperation(value = "get emp Method")
    DataResult<Advertisement> updateActive(@RequestParam int id, @RequestParam boolean active) {
        return this.advertisementService.updateActive(id,active);

    }
    @GetMapping("/getAllByPage")
    DataResult<List<AdvertisementDto>> getAll(@RequestParam int pageNo,@RequestParam int pageSize){
        return this.advertisementService.findAll(pageNo, pageSize);
    }

    @GetMapping("/getAdCustomDate")
    @ApiOperation(value = "get emp Method")
    DataResult<List<AdvertisementDto>> getAdCustomDate(@RequestParam Date date) {
        return this.advertisementService.getAdCustomDate(date);

    }


}
