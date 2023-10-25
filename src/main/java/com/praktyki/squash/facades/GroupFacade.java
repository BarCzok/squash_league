package com.praktyki.squash.facades;

import com.praktyki.squash.facades.dto.GroupDTO;
import com.praktyki.squash.model.Groupss;
import com.praktyki.squash.repository.GroupssRepository;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class GroupFacade {

    @Resource
    private GroupssRepository groupssRepository;



    public List<GroupDTO> getGroupss(){
        Iterable<Groupss> groupss = groupssRepository.findAll();

        return (List<GroupDTO>) convertGroupss(groupss);
    }
    private GroupDTO convertGroupss(Iterable<Groupss> groupss) {
        List<GroupDTO> groupDtos = new ArrayList<>();

        groupss.forEach(x -> groupDtos.add(convertGroupss(x)));

        return (GroupDTO) groupDtos;
    }

    public GroupDTO convertGroupss(Groupss groupss) {
        GroupDTO groupDto = new GroupDTO();

        groupDto.setId(groupss.getId());
        groupDto.setName(groupss.getName());

        return groupDto;
    }


}


