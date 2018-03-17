package com.atlyakov.vshop.controller;

import com.atlyakov.vshop.service.IGoodsFileService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLConnection;
import java.nio.charset.Charset;

@Controller
public class DownloadGoodsFileController {
    private static final Logger LOGGER = Logger.getLogger(DownloadGoodsFileController.class);

    @Autowired
    private IGoodsFileService fileService;

    @RequestMapping(value = {"/user/downloadGoodsFile/{goodsId}"}, method = RequestMethod.GET)
    public void download(HttpServletResponse response, @PathVariable Integer goodsId) throws IOException {

        File file = fileService.getGoodsFileById(goodsId);

        if (!file.exists()) {
            String errorMessage = "Sorry. The file you are looking for does not exist";
            LOGGER.info(errorMessage);
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
            outputStream.close();
            return;
        }

        String mimeType = URLConnection.guessContentTypeFromName(file.getName());
        if (mimeType == null) {
            LOGGER.info("Mime type is not detectable, will take default");
            mimeType = "application/octet-stream";
        }

        LOGGER.info("Mime type : " + mimeType);
        response.setContentType(mimeType);

        response.setHeader("Content-Disposition", String.format("inline; filename=\"%s\"", file.getName()));
        response.setContentLength((int) file.length());

        try (
                FileInputStream fileInputStream = new FileInputStream(file);
                InputStream inputStream = new BufferedInputStream(fileInputStream)
        ) {
            FileCopyUtils.copy(inputStream, response.getOutputStream());
        }

    }

    @RequestMapping(value = {"/admin/downloadGoodsFile/{goodsId}"}, method = RequestMethod.GET)
    public void downloadAdminGoods(HttpServletResponse response, @PathVariable Integer goodsId) throws IOException {
        download(response, goodsId);
    }

}


