package kodlamaio.hrmsdemo.api.controllers;

import io.swagger.annotations.ApiOperation;
import kodlamaio.hrmsdemo.business.abstracts.AdvertisementService;
import kodlamaio.hrmsdemo.core.utilities.results.DataResult;
import kodlamaio.hrmsdemo.entities.concretes.Advertisement;
import kodlamaio.hrmsdemo.entities.dtos.AdvertisementDto;
import kodlamaio.hrmsdemo.entities.dtos.AdvertisementRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("api/adversitements/")
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
    DataResult<AdvertisementRequestDto> add(@RequestBody AdvertisementRequestDto advertisement) {
        return this.advertisementService.addAd(advertisement);

    }
    @GetMapping("/getActive")
    @ApiOperation(value = "get Actv Method")
    DataResult<List<AdvertisementDto>> getActive() {
        return this.advertisementService.getActive();

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

    @GetMapping("/getAdCustomDate")
    @ApiOperation(value = "get emp Method")
    DataResult<List<AdvertisementDto>> getAdCustomDate(@RequestParam Date date) {
        return this.advertisementService.getAdCustomDate(date);

    }
}
