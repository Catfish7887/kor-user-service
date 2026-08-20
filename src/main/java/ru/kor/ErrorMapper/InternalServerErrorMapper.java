package ru.kor.ErrorMapper;

import java.util.Set;

import ru.kor.APIresponse.APIresponse;
import ru.kor.ErrorMapper.utils.ErrorMapper;
import ru.kor.Utils.Exceptions.AppException;
import ru.kor.Utils.Exceptions.ErrorCode;
import ru.kor.Utils.Exceptions.Server.Utils.ServerErrorCode;

public class InternalServerErrorMapper implements ErrorMapper {
	@Override
	public Set<ErrorCode> supportedCodes() {
		return Set.of(ServerErrorCode.values());
	}

	@Override
	public APIresponse mapError(AppException e) {
        System.out.println(e.getCause());
		return new APIresponse("Произошла внутреняя ошибка сервера", 500);
	}

}
