package com.ayp.project.ayp;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.core.io.Resource;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
public class RegistrationController {

        public static  ObjectMapper objectMapper=new ObjectMapper();

    @Autowired
    RegistrationRepository registrationRepository;

    @Autowired
    UserInfoRepository userInfoRepository;

    @Autowired
    FamilyInfoRepository familyInfoRepository;

    @Autowired
    ProfilePhotoRepository profilePhotoRepository;

    @Autowired
    FileStorageService fileStorageService;



    @GetMapping("/GetAll")
    public List<Registration> index(){

        return registrationRepository.findAll();
    }

    @GetMapping("/GetById/{id}")
    public Registration show(@PathVariable String id){
        int regid = Integer.parseInt(id);
        Optional<Registration> registration = this.registrationRepository.findById(regid);
        if (registration.isPresent()) {
            return registration.get();
        } else {
            return null;
        }
    }

    @GetMapping("/GetByPhone/{phone}")
    public Registration getByPhone(@PathVariable String phone){
        Registration rgr=registrationRepository.findByPhone(phone);
        System.out.println(rgr.getPhoneNo()+" "+rgr.getCategory()+" "+rgr.getRegId());
        return rgr;
    }

    @PutMapping("/Update/{phone}")
    public Registration update(@PathVariable String phone, @RequestBody String body){
        // getting blog
        Registration registration = registrationRepository.findByPhone(phone);
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.setVisibilityChecker(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
        Object value=null;
        try {
            value = objectMapper.readValue(body, RegModel.class);
        }
        catch(IOException io)
        {
            System.out.println(io);
        }
        registration.setFirstName(((RegModel) value).getFirstName());
        registration.setLastname(((RegModel) value).getLastname());
        registration.setEmail(((RegModel) value).getEmail());
        registration.setPhoneNo(((RegModel) value).getPhoneNo());
        registration.setCategory(((RegModel) value).getCategory());
        return registrationRepository.save(registration);
    }

    @DeleteMapping("Delete/{phone}")
    public boolean delete(@PathVariable String phone){
        Registration registration = registrationRepository.findByPhone(phone);
        registrationRepository.delete(registration);
        return true;
    }



    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Registration create(@RequestBody String body){
//        UserInfo userInfo=UserInfo.getInstance();
        UserInfo userInfo=new UserInfo();
        FamilyInfo familyInfo=new FamilyInfo();
        ProfilePhoto profilePhoto =new ProfilePhoto();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.setVisibilityChecker(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
        Object value=null;
        try {
            value = objectMapper.readValue(body, Registration.class);

        }
        catch(IOException io)
        {
            System.out.println(io);
        }

        Registration registration=registrationRepository.save((Registration)value);
        int id=registrationRepository.GetRegId(registration.getPhoneNo());
        userInfo.setRegId(id);
        familyInfo.setRegId(id);
        profilePhoto.setRegId(id);
        userInfoRepository.save(userInfo);
        familyInfoRepository.save(familyInfo);
        profilePhotoRepository.save(profilePhoto);
        return registration;
    }

    @GetMapping("/GetRegId/{phone}")
    public HashMap<String, Integer> getId(@PathVariable String phone)
    {
        int id=registrationRepository.GetRegId(phone);
        HashMap<String,Integer> jsonId=new HashMap<String, Integer>();
        jsonId.put("RegId",id);
        return jsonId;
    }

    @PutMapping("/updateUserInfo/{regid}")
    public UserInfo updateUserInfo(@PathVariable String regid, @RequestBody String body){
        int id = Integer.parseInt(regid);
       UserInfo userInfo=userInfoRepository.userRegId(id);
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.setVisibilityChecker(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
        Object value=null;
        try {
            value = objectMapper.readValue(body, UserModel.class);
        }
        catch(IOException io)
        {
            System.out.println(io);
        }
        userInfo.setFatherName(((UserModel)value).getFatherName());
        userInfo.setGotra(((UserModel)value).getGotra());
        userInfo.setMobileNo2(((UserModel)value).getMobileNo2());
        userInfo.setLandLineNo1(((UserModel)value).getLandLineNo1());
        userInfo.setLandLineNo2(((UserModel)value).getLandLineNo2());
        userInfo.setAdd1(((UserModel)value).getAdd1());
        userInfo.setAdd2(((UserModel)value).getAdd2());
        userInfo.setAdd3(((UserModel)value).getAdd3());
        userInfo.setCity(((UserModel)value).getCity());
        userInfo.setPin(((UserModel)value).getPin());
        userInfo.setState(((UserModel)value).getState());
        userInfo.setBloodGroup(((UserModel)value).getBloodGroup());
        userInfo.setDob(((UserModel)value).getDob());
        userInfo.setDom(((UserModel)value).getDom());
        return userInfoRepository.save(userInfo);

    }



    @PutMapping("/updateFamilyInfo/{regid}")
    public FamilyInfo updateFamilyInfo(@PathVariable String regid, @RequestBody String body){
        int id = Integer.parseInt(regid);
        FamilyInfo familyInfo=familyInfoRepository.familyRegId(id);
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.setVisibilityChecker(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
        Object value=null;
        try {
            value = objectMapper.readValue(body, FamilyModel.class);
        }
        catch(IOException io)
        {
            System.out.println(io);
        }
        familyInfo.setSpouce(((FamilyModel)value).getSpouce());
        familyInfo.setDobSpouce(((FamilyModel)value).getDobSpouce());
        familyInfo.setChild1(((FamilyModel)value).getChild1());
        familyInfo.setDobChild1(((FamilyModel)value).getDobChild1());
        familyInfo.setChild2(((FamilyModel)value).getChild2());
        familyInfo.setDobChild2(((FamilyModel)value).getDobChild2());
        familyInfo.setChild3(((FamilyModel)value).getChild3());
        familyInfo.setDobChild3(((FamilyModel)value).getDobChild3());
        return familyInfoRepository.save(familyInfo);

    }

    @GetMapping("/GetUserInfo/{regid}")
    public UserInfo getUserInfo(@PathVariable int regid)
    {
        UserInfo userInfo=userInfoRepository.userRegId(regid);
        return userInfo;
    }

    @GetMapping("/GetFamilyInfo/{regid}")
    public FamilyInfo getFamilyInfo(@PathVariable int regid)
    {
        FamilyInfo familyInfo=familyInfoRepository.familyRegId(regid);
        return familyInfo;
    }

    @RequestMapping(value = "/upload/{regid}", method = RequestMethod.PUT, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ProfilePhoto updateprofilePhoto(@PathVariable String regid,
                                           @RequestParam(required = true, value = "file") MultipartFile file) throws IOException
    {
        int id = Integer.parseInt(regid);
        ProfilePhoto profilePhoto=profilePhotoRepository.profilePhotoRegId(id);
        String fileName = fileStorageService.storeFile(file,regid);
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
                .path(fileName).toUriString();

        profilePhoto.setPath(fileDownloadUri);

        return profilePhotoRepository.save(profilePhoto);

    }


    @RequestMapping(value = "/downloadFile/{regid}", method = RequestMethod.GET)
    public ResponseEntity<Resource> downloadFile(@PathVariable String regid, HttpServletRequest request) {
        System.out.println("hitted the api");
        Resource resource = fileStorageService.loadFileAsResource(regid);
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        if (contentType == null) {
            contentType = "application/octet-stream";
        }
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        String.format("attachment; filename=\\\"%s\\\"", resource.getFilename()))
                .body(resource);
    }


}
