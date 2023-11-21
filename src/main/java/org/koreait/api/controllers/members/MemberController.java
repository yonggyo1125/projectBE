package org.koreait.api.controllers.members;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.koreait.commons.Utils;
import org.koreait.commons.exceptions.BadRequestException;
import org.koreait.commons.rests.JSONData;
import org.koreait.models.member.MemberSaveService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/member")
@RequiredArgsConstructor
public class MemberController {

    private MemberSaveService saveService;

    @PostMapping
    public JSONData join(@RequestBody @Valid RequestJoin form, Errors errors) {
        saveService.save(form, errors);

        if (errors.hasErrors()) {
            throw new BadRequestException(Utils.getMessages(errors));
        }

        JSONData data = new JSONData();
        data.setStatus(HttpStatus.CREATED);

        return data;
    }
}
