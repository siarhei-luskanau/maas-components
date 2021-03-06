public struct NearbyTransitFilterView: View {

    public let items: [FilterItem]
    public var didTapItem: (FilterItem.ID) -> ()
    public var disabledItems: Set<FilterItem.ID>

    public init(items: [FilterItem], didTapItem: @escaping (FilterItem.ID) -> (), disabledItems: Set<FilterItem.ID>) {
        self.items = items
        self.didTapItem = didTapItem
        self.disabledItems = disabledItems
    }

    public var body: some View {
        MultiSelectFilter(
            items: items,
            itemView: NearbyTransitFilterItemView.init,
            didTapItem: didTapItem,
            disabledItems: disabledItems
        )
    }
}

// MARK: - Preview
#if DEBUG
public struct NearbyTransitFilterView_Previews: PreviewProvider, Snapped {

    public static var snapped: [String: AnyView] {
        [
            "Filter": AnyView(
                MultiSelectFilter(
                    items: NearbyTransitComponentsPreviewData.mockFilterDataItems,
                    itemView: NearbyTransitFilterItemView.init,
                    didTapItem: { _ in },
                    disabledItems: [
                        NearbyTransitComponentsPreviewData.mockFilterDataItems[0].id,
                        NearbyTransitComponentsPreviewData.mockFilterDataItems[2].id,
                        NearbyTransitComponentsPreviewData.mockFilterDataItems[4].id
                    ]
                )
            ),

            "Swapped": AnyView(
                MultiSelectFilter(
                    items: NearbyTransitComponentsPreviewData.mockFilterDataItems,
                    itemView: NearbyTransitFilterItemView.init,
                    didTapItem: { _ in },
                    disabledItems: [
                        NearbyTransitComponentsPreviewData.mockFilterDataItems[0].id,
                        NearbyTransitComponentsPreviewData.mockFilterDataItems[2].id,
                        NearbyTransitComponentsPreviewData.mockFilterDataItems[4].id]
                )
                .swapView(MockItem.init, insteadOf: NearbyTransitFilterItemView.self)
            )
        ]
    }

    public static var elementWidth: CGFloat? { 290 }
}

// MARK: - Mock Data

private struct MockItem: View {

    let input: NearbyTransitFilterItemView.InputType

    init(input: NearbyTransitFilterItemView.InputType) {
        self.input = input
    }

    var body: some View {
        ZStack {
            RoundedRectangle(cornerRadius: 4)
                .frame(width: 28, height: 28, alignment: .center)
                .foregroundColor(input.isDisabled ? .init(.systemGray2) : input.data.color.parseColor())
            Image.from(image: UIImage(named: input.data.icon))
                .frame(width: 20, height: 20, alignment: .center)
        }
        .padding(4)
    }
}
#endif
