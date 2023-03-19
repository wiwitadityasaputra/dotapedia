import { Pipe, PipeTransform } from "@angular/core";

@Pipe({name: 'region'})
export class RegionPipe implements PipeTransform {
  transform(value: string | undefined): string {
    if ("WESTERN_EUROPE" === value) {
        return "Western EU";
    } else if ("EASTERN_EUROPE" === value) {
        return "Eastern EU";
    } else if ("CHINA" === value) {
        return "China";
    } else if ("SOUTHEAST_ASIA" === value) {
        return "SE Asia";
    } else if ("NORTH_AMERICA" === value) {
        return "North America";
    } else if ("SOUTH_AMERICA" === value) {
        return "South America";
    }
    return value ? value : "";
  }
}