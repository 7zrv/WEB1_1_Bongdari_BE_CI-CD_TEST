package com.somemore.volunteer.service.query;

import com.somemore.volunteer.domain.Volunteer;
import com.somemore.volunteer.dto.response.VolunteerForCommunityResponseDto;
import com.somemore.volunteer.repository.VolunteerRepository;
import com.somemore.volunteer.usecase.query.FindVolunteerIdUseCase;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FindVolunteerIdService implements FindVolunteerIdUseCase {

    private final VolunteerRepository volunteerRepository;

    @Override
    public UUID findVolunteerIdByOAuthId(String oAuthId) {
        return volunteerRepository.findByOauthId(oAuthId)
                .orElseThrow(EntityNotFoundException::new)
                .getId();
    }

    @Override
    public String getNicknameById(UUID id) {
        return volunteerRepository.findNicknameById(id);
    }

    @Override
    public VolunteerForCommunityResponseDto getVolunteerDetailForCommunity(UUID id) {
        Volunteer volunteer = volunteerRepository.findById(id);

        return VolunteerForCommunityResponseDto.fromEntity(volunteer);
    }
}
