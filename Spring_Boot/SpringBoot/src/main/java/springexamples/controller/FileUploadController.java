package springexamples.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Slf4j
@Controller
public class FileUploadController {

    @GetMapping("/fileupload")
    public ModelAndView fileUpload() throws IOException {
        ModelAndView response = new ModelAndView("fileupload");

        return response;
    }

    @PostMapping("/fileupload")
    public ModelAndView fileUpload(@RequestParam("fileupload") MultipartFile fileUpload) throws IOException {
        ModelAndView response = new ModelAndView("fileupload");

        //the target location of where the incoming file is to saved
        File target = new File("./src/main/webapp/pub/images/" + fileUpload.getOriginalFilename());
        log.debug(target.getAbsolutePath());

        //convenience method provided by commons-io library
        //the browser offer the file to be uploaded as an input stream to the server --
        // -- this method does all the work reading the  file upload input stream, and writing it to the target filesystem
        FileUtils.copyInputStreamToFile(fileUpload.getInputStream(), target);

        response.addObject("fileUrl", "/pub/images/" + fileUpload.getOriginalFilename());
        return response;
    }
}