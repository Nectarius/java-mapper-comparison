package tea.mapstruct;

import org.mapstruct.MapperConfig;
import org.mapstruct.MappingInheritanceStrategy;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;

/**
 * Created by nefarius on 4/12/15.
 */
@MapperConfig(
        mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG,
        unmappedTargetPolicy = ReportingPolicy.WARN,
        componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL
)
public interface CentralConfig {


}
