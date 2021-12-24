package cn.wsg.library.service;

import cn.wsg.library.common.dto.AuthorDTO;
import cn.wsg.library.dao.mapper.AuthorMapper;
import cn.wsg.library.entity.AuthorDO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Kingen
 */
@Service("authorService")
public class AuthorServiceImpl implements AuthorService {

    private final AuthorMapper authorMapper;

    @Autowired
    public AuthorServiceImpl(AuthorMapper authorMapper) {
        this.authorMapper = authorMapper;
    }

    @Override
    public int countByName(String name) {
        return authorMapper.countByName(name);
    }

    @Override
    public int saveAuthor(AuthorDTO authorDto) {
        AuthorDO author = new AuthorDO();
        BeanUtils.copyProperties(authorDto, author);
        return authorMapper.insert(author);
    }

    @Override
    public List<AuthorDTO> listAuthorsByName(String keyword) {
        return authorMapper.listByName(keyword).stream().map(author -> {
            AuthorDTO authorDto = new AuthorDTO();
            BeanUtils.copyProperties(author, authorDto);
            return authorDto;
        }).collect(Collectors.toList());
    }
}
