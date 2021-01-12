@testable import Maas
import Quick
import NearbyTransit

final class Features: QuickSpec {
    override func spec() {
        snapshot(RouteSegmentView_Previews.self)
        snapshot(NearbyTransitFilterItemView_Previews.self)
        snapshot(NearbyTransitFilterView_Previews.self)
        snapshot(NearbyTransitScheduleBadgesScrollView_Previews.self)
        snapshot(NearbyTransitStopBadgeView_Previews.self)
    }
}
