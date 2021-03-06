package cn.wsg.repository.common.dto;

import cn.wsg.repository.common.enums.ReadStatus;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * Extra properties of a book.
 *
 * @author Kingen
 */
@Getter
@ToString
public class BookDTO extends BaseBookDTO {

    private List<AuthorDTO> authors;

    private List<AuthorDTO> translators;

    private ReadStatus readStatus;
}
