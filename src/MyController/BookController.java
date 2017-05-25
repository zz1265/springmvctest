package MyController;

import model.Book;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

/**
 * Created by Archibald on 2/6/2017.
 */
@Controller
public class BookController {
    @Autowired
    private HttpServletRequest request;
    @RequestMapping("/save.do")
    public String booksave(int a, Map map){
        map.put("msg","good");
        try {
            System.out.println("save + ");
        } catch (Exception e) {
            e.printStackTrace();
        }
        String aa="";
        Collections collections=null;
        Book book = new Book();
        return "test";
    }
    @RequestMapping("/test.do")
    @ResponseBody
    public String test(int mm){
        return mm+"";
    }
    @RequestMapping("/upload.do")
    public String fileUpload(MultipartFile picFile){
        System.out.println("picFile= "+picFile);
        String path=request.getSession().getServletContext().getRealPath("/image");
        System.out.println("path= "+path);
        String path2=path+"\\test.jpg";
        File file=new File(path,picFile.getOriginalFilename());
        try {
            picFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("pic","image/"+picFile.getOriginalFilename());
        request.getSession().setAttribute("picName",picFile.getOriginalFilename());
        return "index";
    }
    @RequestMapping("/download.do")
    public ResponseEntity<byte[]> download(HttpSession session, String fname) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//			headers.setContentDispositionFormData("attachment", "notepadplus.zip");
            headers.set("Content-Disposition", "attachment; filename="+fname);

            String path = session.getServletContext().getRealPath("/image");
            File file = new File(path ,fname);
            System.out.println("down..........:"+path);
            return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                    headers, HttpStatus.OK);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
