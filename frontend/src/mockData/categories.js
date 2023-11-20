import './news.json';

export default function getCategories(news) {
    return news.map((news) => news.category).filter(
        (category, index, self) =>
            self.findIndex((c) => c.id === category.id) === index
    );
}